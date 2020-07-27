package com.patronusstudio.sisecevirmece.ui

import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.abstracts.CesaretDatabase
import com.patronusstudio.sisecevirmece.abstracts.CesaretEklendiDatabase
import com.patronusstudio.sisecevirmece.abstracts.DogrulukDatabase
import com.patronusstudio.sisecevirmece.abstracts.DogrulukEklendiDatabase
import com.patronusstudio.sisecevirmece.databinding.ActivitySoruEkleBinding
import com.patronusstudio.sisecevirmece.enums.DogrulukCesaretEnum
import com.patronusstudio.sisecevirmece.model.CesaretModel
import com.patronusstudio.sisecevirmece.model.CesaretSoruEklenenModel
import com.patronusstudio.sisecevirmece.model.DogrulukModel
import com.patronusstudio.sisecevirmece.model.DogrulukSoruEklenenModel
import com.patronusstudio.sisecevirmece.util.OyunIslemleri
import com.patronusstudio.sisecevirmece.util.SharedVeriSaklama

class SoruEkleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySoruEkleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_soru_ekle)

        val getBooleanIntent =
            intent.getBooleanExtra(DogrulukCesaretEnum.DOGRULUK_CESARET.isim, false)

        binding.butonSoruEkle.setOnClickListener {
            val girilenSoru = binding.edxGirilenSoru.text
            val sonuc = textControl(girilenSoru, getBooleanIntent)

            if (sonuc) {
                Toast.makeText(this, getString(R.string.soru_kayit_basarili), Toast.LENGTH_SHORT)
                    .show()
                finish()
            } else Toast.makeText(this, getString(R.string.soru_kayit_hatali), Toast.LENGTH_SHORT)
                .show()
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

                val model2 = DogrulukSoruEklenenModel(soru = girilenSoru.toString())
                DogrulukEklendiDatabase.getDatabaseManager(this).dogrulukEklenenDao().insert(model2)
                OyunIslemleri.dogrulukEklenenSize++
                sharedPref.updateDogrulukEklenenSize(OyunIslemleri.dogrulukEklenenSize)

            } else {
                val model = CesaretModel(soru = girilenSoru.toString())
                CesaretDatabase.getDatabaseManager(this).cesaretDao().insert(model)
                OyunIslemleri.cesaretSize++
                sharedPref.updateCesaretSize(OyunIslemleri.cesaretSize)

                val model2 = CesaretSoruEklenenModel(soru = girilenSoru.toString())
                CesaretEklendiDatabase.getDatabaseManager(this).cesareEklenentDao().insert(model2)
                OyunIslemleri.cesaretEklenenSize++
                sharedPref.updateCesaretEklenenSize(OyunIslemleri.cesaretEklenenSize)
            }
            OyunIslemleri.guncellenenSoru = girilenSoru.toString()
            OyunIslemleri.soruEklendiMi = true
            true
        } else false

    }
}
