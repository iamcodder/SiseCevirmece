package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.databinding.ActivityDogrulukCesaretBinding
import com.frappeclub.sisecevirmece.enums.DogrulukCesaret

class SecimEkraniActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDogrulukCesaretBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_secim_ekrani)

        binding.cesaret = DogrulukCesaret.CESARET.isim
        binding.dogruluk = DogrulukCesaret.DOGRULUK.isim

        binding.cardviewGroup.imgDogruluk.setOnClickListener {
            it.context.extSayfaGecisi(SoruActivity::class.java, true)
            finish()
        }

        binding.cardviewGroup.imgCesaret.setOnClickListener {
            it.context.extSayfaGecisi(SoruActivity::class.java)
            finish()
        }

    }

}
