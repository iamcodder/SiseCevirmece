package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.abstracts.CesaretDatabase
import com.frappeclub.sisecevirmece.abstracts.DogrulukDatabase
import com.frappeclub.sisecevirmece.databinding.ActivitySoruEkleBinding
import com.frappeclub.sisecevirmece.enums.DogrulukCesaret
import com.frappeclub.sisecevirmece.model.CesaretModel
import com.frappeclub.sisecevirmece.model.DogrulukModel
import com.frappeclub.sisecevirmece.util.OyunIslemleri
import com.frappeclub.sisecevirmece.util.SharedVeriSaklama
import com.frappeclub.sisecevirmece.util.extStatusBarColor

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

        if (!girilenSoru.isNullOrBlank()) {
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
                sharedPref.updateDogrulukSize(OyunIslemleri.cesaretSize)
            }
            return true
        } else return false

    }
}
