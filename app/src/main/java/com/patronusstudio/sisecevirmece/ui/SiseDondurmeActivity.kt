package com.patronusstudio.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.binding.SiseDondurmeOnClickBinding
import com.patronusstudio.sisecevirmece.databinding.ActivitySiseDondurmeBinding
import com.patronusstudio.sisecevirmece.util.CustomTimer
import com.patronusstudio.sisecevirmece.util.OyunIslemleri
import com.patronusstudio.sisecevirmece.util.extSayfaGecisi

class SiseDondurmeActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySiseDondurmeBinding
    private lateinit var customTimer: CustomTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sise_dondurme)
        imgKontrol()

        val sayacBitince = {
            this.extSayfaGecisi(SecimEkraniActivity::class.java)
        }

        customTimer = CustomTimer(sayacBitince)
        binding.sise = SiseDondurmeOnClickBinding()
        binding.customTimer = customTimer

        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)

    }

    private fun imgKontrol() {

        val resId =
            when (OyunIslemleri.siseTuru) {
                0 -> R.drawable.cola
                1 -> R.drawable.whisky
                2 -> R.drawable.wine
                3 -> R.drawable.beer
                else -> R.drawable.beer
            }

        Glide
            .with(this)
            .load(resId)
            .into(binding.siseDonen)
    }

    override fun onResume() {
        super.onResume()
        binding.siseDonen.isEnabled = true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        customTimer.sayacDurdur()
    }


}


