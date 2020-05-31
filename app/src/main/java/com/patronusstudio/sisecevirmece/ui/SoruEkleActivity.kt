package com.patronusstudio.sisecevirmece.ui

import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.abstracts.CesaretDatabase
import com.patronusstudio.sisecevirmece.abstracts.DogrulukDatabase
import com.patronusstudio.sisecevirmece.databinding.ActivitySoruEkleBinding
import com.patronusstudio.sisecevirmece.enums.DogrulukCesaret
import com.patronusstudio.sisecevirmece.model.CesaretModel
import com.patronusstudio.sisecevirmece.model.DogrulukModel
import com.patronusstudio.sisecevirmece.util.OyunIslemleri
import com.patronusstudio.sisecevirmece.util.SharedVeriSaklama
import com.patronusstudio.sisecevirmece.util.extStatusBarColor

class SoruEkleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySoruEkleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_soru_ekle)
        this extStatusBarColor "#01A555"

        val getBooleanIntent = intent.getBooleanExtra(DogrulukCesaret.DOGRULUK_CESARET.isim, false)

        binding.butonSoruEkle.setOnClickListener {
            val girilenSoru = binding.edxGirilenSoru.text
            val sonuc = textControl(girilenSoru, getBooleanIntent)
            val toastMessage = if (sonuc) "Kayıt Başarılı"
            else "Girilen soruyu kontrol ediniz."
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        }

    }

    private fun textControl(girilenSoru: Editable?, getBooleanIntent: Boolean): Boolean {

        return if (!girilenSoru.isNullOrBlank()) {
            val sharedPref = SharedVeriSaklama(this)
            if (getBooleanIntent) {
                val model = DogrulukModel(soru = girilenSoru.toString())
                DogrulukDatabase.getDatabaseManager(this).dogrulukDao().insert(model)
                OyunIslemleri.dogrulukSize++
                sharedPref.updateDogrulukSize(OyunIslemleri.dogrulukSize)
            } else {
                val model = CesaretModel(soru = girilenSoru.toString())
                CesaretDatabase.getDatabaseManager(this).cesaretDao().insert(model)
                OyunIslemleri.cesaretSize++
                sharedPref.updateCesaretSize(OyunIslemleri.cesaretSize)
            }
            true
        } else false

    }
}
