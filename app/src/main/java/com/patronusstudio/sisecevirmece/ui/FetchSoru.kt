package com.patronusstudio.sisecevirmece.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.admob.AdmobTool
import com.patronusstudio.sisecevirmece.databinding.ActivityFetchSoruBinding
import com.patronusstudio.sisecevirmece.model.SoruPaketi
import com.patronusstudio.sisecevirmece.network.FirebaseGet
import com.patronusstudio.sisecevirmece.util.OyunIslemleri
import com.patronusstudio.sisecevirmece.util.SharedVeriSaklama
import com.patronusstudio.sisecevirmece.util.extToastMessage
import com.patronusstudio.sisecevirmece.util.isInternetConnection

class FetchSoru : AppCompatActivity() {

    private lateinit var binding: ActivityFetchSoruBinding
    private lateinit var soruPaketi: SoruPaketi
    private lateinit var admobTool: AdmobTool

    private var dogrulukMu: Boolean = false
    private var soruListesi = mutableListOf<String>()

    private val firebaseGet by lazy {
        FirebaseGet({
            soruPaketi = it
            soruKontrolu()
        }
            ,
            { soruListesi: MutableList<String>, dogrulukMu: Boolean ->
                this.dogrulukMu = dogrulukMu
                this.soruListesi = soruListesi
                admobTool.loadAd()
            })
    }

    private val sharedVeriSaklama by lazy {
        SharedVeriSaklama(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fetch_soru)

        val isConnection = isInternetConnection(this)
        if (!isConnection) {
            this.extToastMessage("İnternet bağlantısı mevcut değil")
            finish()
        } else {
            binding.progressBar.visibility = View.VISIBLE

            firebaseGet.getToplamSoru()
            buttonIslevleri()

            admobTool = AdmobTool(this) { isSucces: Boolean, message: String ->
                if (!isSucces) {
                    this.extToastMessage(message)
                } else {
                    dbSoruEkle(this.dogrulukMu, this.soruListesi)
                }
                finish()
            }
        }
    }


    private fun dbSoruEkle(dogrulukMu: Boolean, soruListesi: MutableList<String>) {
        var toplamPaket: Int = OyunIslemleri.toplamSoruPaketi.toInt()
        toplamPaket++
        if (dogrulukMu) {
            var dogrulukPaketi: Int = OyunIslemleri.dogrulukSoruPaketi.toInt()
            dogrulukPaketi++
            OyunIslemleri.dogrulukSoruPaketi = "$dogrulukPaketi"
            sharedVeriSaklama.updateSoruPaketi(
                "$toplamPaket",
                "$dogrulukPaketi", true
            )
            //todo : shared pref güncellendi.Dbye yazma yaptır

        } else {
            var cesaretSoruPaketi = OyunIslemleri.cesaretSoruPaketi.toInt()
            cesaretSoruPaketi++
            OyunIslemleri.cesaretSoruPaketi = "$cesaretSoruPaketi"
            sharedVeriSaklama.updateSoruPaketi(
                "$toplamPaket",
                "$cesaretSoruPaketi", false
            )
            //todo : shared pref güncellendi.Dbye yazma yaptır

        }
        OyunIslemleri.toplamSoruPaketi = "$toplamPaket"

    }


    private fun buttonIslevleri() {
        binding.buttonHayir.setOnClickListener {
            finish()
        }
        binding.buttonEvet.setOnClickListener {
            dialog_visible()
            admobTool.loadAd()
        }
    }

    private fun dialog_invisible() {
        binding.progressBar.visibility = View.GONE
        binding.buttonEvet.visibility = View.VISIBLE
        binding.buttonHayir.visibility = View.VISIBLE
        binding.cardReklamYukleme.visibility = View.VISIBLE
    }

    private fun dialog_visible() {
        binding.progressBar.visibility = View.VISIBLE
        binding.buttonEvet.visibility = View.GONE
        binding.buttonHayir.visibility = View.GONE
        binding.cardReklamYukleme.visibility = View.GONE
    }


    private fun soruKontrolu() {
        val (fbToplamPaket, fbDogrulukPaket, fbCesaretPaket) = soruPaketi
        if (fbToplamPaket.toInt() > OyunIslemleri.toplamSoruPaketi.toInt()) {

            var dogrulukSoruPaketi = OyunIslemleri.dogrulukSoruPaketi.toInt()
            var cesaretSoruPaketi = OyunIslemleri.cesaretSoruPaketi.toInt()
            dialog_invisible()
            if (fbDogrulukPaket.toInt() > dogrulukSoruPaketi) {
                dogrulukSoruPaketi++
                firebaseGet.getSorular("$dogrulukSoruPaketi", true)
            } else if (fbCesaretPaket.toInt() > cesaretSoruPaketi) {
                cesaretSoruPaketi++
                firebaseGet.getSorular("$cesaretSoruPaketi", false)
            }
        } else {
            this.extToastMessage("Güncel soru bulunamadı")
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        admobTool.resumeAd()
    }

    override fun onPause() {
        super.onPause()
        admobTool.pauseAd()
    }

    override fun onDestroy() {
        super.onDestroy()
        admobTool.destroyAd()
    }
}