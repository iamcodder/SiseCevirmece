package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.binding.SoruDuzenleOnClickBinding
import com.frappeclub.sisecevirmece.databinding.ActivitySoruDuzenleBinding
import com.frappeclub.sisecevirmece.enums.DogrulukCesaret
import com.frappeclub.sisecevirmece.model.CesaretModel
import com.frappeclub.sisecevirmece.model.DogrulukModel

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

        val getBoolean = intent.getBooleanExtra(DogrulukCesaret.DOGRULUK_CESARET.isim, false)
        val getModel = if (getBoolean)
            intent.getParcelableExtra(DogrulukCesaret.SORU_MODELI.isim) as DogrulukModel
        else intent.getParcelableExtra(DogrulukCesaret.SORU_MODELI.isim) as CesaretModel

        binding.soruDuzenleOnClick =
            SoruDuzenleOnClickBinding(this, getBoolean, getModel, activitySonlandir)

        if (getBoolean) {
            binding.text = (getModel as DogrulukModel).soru
        } else binding.text = (getModel as CesaretModel).soru
    }
}