package com.patronusstudio.sisecevirmece.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.patronusstudio.sisecevirmece.R
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

    private val firebaseGet by lazy {
        FirebaseGet {
            soruPaketi = it
            soruKontrolu()
        }
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
        }
    }

    private fun soruKontrolu() {
        val (fbToplamPaket, fbDogrulukPaket, fbCesaretPaket) = soruPaketi
        if (fbToplamPaket.toInt() > OyunIslemleri.toplamSoruPaketi.toInt()) {

            var dogrulukSoruPaketi = OyunIslemleri.dogrulukSoruPaketi.toInt()
            var cesaretSoruPaketi = OyunIslemleri.cesaretSoruPaketi.toInt()
            var toplamSoruPaketi = OyunIslemleri.toplamSoruPaketi.toInt()

            if (fbDogrulukPaket.toInt() > dogrulukSoruPaketi) {
                //  todo : burada dialog gösterilecek ve reklam yüklemesi başlatılacak
                // eğer reklam succes alırsa alttakiler yapılacak ve sorularda dbye yazılacak
                dogrulukSoruPaketi++
                toplamSoruPaketi++
                firebaseGet.getSorular("$dogrulukSoruPaketi", true)
                OyunIslemleri.dogrulukSoruPaketi = "$dogrulukSoruPaketi"
                sharedVeriSaklama.updateSoruPaketi("$toplamSoruPaketi", "$dogrulukSoruPaketi", true)
            } else if (fbCesaretPaket.toInt() > cesaretSoruPaketi) {
                //  todo : burada dialog gösterilecek ve reklam yüklemesi başlatılacak
                // eğer reklam succes alırsa alttakiler yapılacak ve sorularda dbye yazılacak
                cesaretSoruPaketi++
                toplamSoruPaketi++
                firebaseGet.getSorular("$cesaretSoruPaketi", false)
                OyunIslemleri.cesaretSoruPaketi = "$cesaretSoruPaketi"
                sharedVeriSaklama.updateSoruPaketi("$toplamSoruPaketi", "$cesaretSoruPaketi", false)
            }


        } else {
            this.extToastMessage("Güncel soru bulunamadı")
            finish()
        }
    }
}