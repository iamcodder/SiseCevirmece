package com.patronusstudio.sisecevirmece.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.abstracts.CesaretDatabase
import com.patronusstudio.sisecevirmece.abstracts.DogrulukDatabase
import com.patronusstudio.sisecevirmece.databinding.ActivityOyunSifirlaBinding
import com.patronusstudio.sisecevirmece.util.OyunIslemleri
import com.patronusstudio.sisecevirmece.util.SharedVeriSaklama
import com.patronusstudio.sisecevirmece.util.SoruEkleme
import com.patronusstudio.sisecevirmece.util.extStatusBarColor

class OyunSifirlaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOyunSifirlaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_oyun_sifirla)
        this extStatusBarColor "#00000000"

        binding.buttonVerileriSil.setOnClickListener {
            binding.veriSilmeProgress.visibility = View.VISIBLE
            veriSil()
            binding.veriSilmeProgress.visibility = View.GONE
            Toast.makeText(this, getString(R.string.sifirlandi), Toast.LENGTH_SHORT).show()
            butonSetVeFinish()
        }

        binding.buttonIptalEt.setOnClickListener {
            Toast.makeText(this, getString(R.string.iptal_edildi), Toast.LENGTH_SHORT).show()
            butonSetVeFinish()
        }
    }

    private fun butonSetVeFinish() {
        OyunIslemleri.dialogButonunaBasildiMi = true
        finish()
    }

    private fun veriSil() {
        val sharedVeriSaklama = SharedVeriSaklama(this)
        sharedVeriSaklama.clearSharedPref()
        val soruEkleme = SoruEkleme(this)
        val cesaretDatabase = CesaretDatabase.getDatabaseManager(this)
        cesaretDatabase.cesaretDao().deleteAllModel()
        cesaretDatabase.cesaretDao().insertAll(soruEkleme.cesaretListesiEkleme())

        val dogrulukDatabase = DogrulukDatabase.getDatabaseManager(this)
        dogrulukDatabase.dogrulukDao().deleteAllModel()
        dogrulukDatabase.dogrulukDao().insertAll(soruEkleme.dogrulukListesiEkleme())

        sharedVeriSaklama.putValueForFirstStarted(
            true,
            soruEkleme.dogrulukListSize,
            soruEkleme.cesaretListSize,
            0
        )
        OyunIslemleri.toplamSoruPaketi = sharedVeriSaklama.getToplamSoruPaketi() ?: "0"
        OyunIslemleri.dogrulukSoruPaketi = sharedVeriSaklama.getDogrulukSoruPaketi() ?: "0"
        OyunIslemleri.cesaretSoruPaketi = sharedVeriSaklama.getCesaretSoruPaketi() ?: "0"

        OyunIslemleri.cesaretSize = sharedVeriSaklama.getCesaretListValue()
        OyunIslemleri.dogrulukSize = sharedVeriSaklama.getDogrulukListValue()

        OyunIslemleri.cesaretLastValue = sharedVeriSaklama.getCesaretSize()
        OyunIslemleri.dogrulukLastValue = sharedVeriSaklama.getDogrulukSize()

        OyunIslemleri.siseTuru = sharedVeriSaklama.getSiseTuru()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        OyunIslemleri.dialogButonunaBasildiMi = true
    }

}