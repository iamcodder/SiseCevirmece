package com.patronusstudio.sisecevirmece.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.binding.SoruDuzenleOnClickBinding
import com.patronusstudio.sisecevirmece.databinding.ActivitySoruDuzenleBinding
import com.patronusstudio.sisecevirmece.enums.DogrulukCesaret
import com.patronusstudio.sisecevirmece.model.CesaretModel
import com.patronusstudio.sisecevirmece.model.DogrulukModel

class SoruDuzenleActivitiy : AppCompatActivity() {

    private lateinit var binding: ActivitySoruDuzenleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_soru_duzenle)

        val activitySonlandir = { mesaj: String, bitirelecekMi: Boolean ->
            Toast.makeText(this, mesaj, Toast.LENGTH_SHORT).show()
            if (bitirelecekMi) {
                finish()
            }
        }
        val soruIndexi = intent.getIntExtra(DogrulukCesaret.SORUNUN_INDEXI.isim, 0)
        val getBoolean = intent.getBooleanExtra(DogrulukCesaret.DOGRULUK_CESARET.isim, false)
        val getModel = if (getBoolean)
            intent.getParcelableExtra(DogrulukCesaret.SORU_MODELI.isim) as DogrulukModel
        else intent.getParcelableExtra(DogrulukCesaret.SORU_MODELI.isim) as CesaretModel

        binding.soruDuzenleOnClick =
            SoruDuzenleOnClickBinding(this, soruIndexi, getBoolean, getModel, activitySonlandir)

        if (getBoolean) {
            binding.text = (getModel as DogrulukModel).soru
        } else binding.text = (getModel as CesaretModel).soru
    }
}