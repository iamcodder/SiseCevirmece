package com.patronusstudio.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.databinding.ActivityHomeBinding
import com.patronusstudio.sisecevirmece.util.extSayfaGecisi
import com.patronusstudio.sisecevirmece.util.extStatusBarColor

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        this extStatusBarColor "#01A555"

        binding.imgBeer.setOnClickListener {
            this.extSayfaGecisi(SiseDondurmeActivity::class.java)
        }

        binding.imgSoru.setOnClickListener {
            this.extSayfaGecisi(SorulariGoruntuleSecimEkrani::class.java)
        }
        binding.imgAyarlar.setOnClickListener {
            this.extSayfaGecisi(AyarlarActivity::class.java)
        }
        binding.imgStore.setOnClickListener {
        }
    }

}