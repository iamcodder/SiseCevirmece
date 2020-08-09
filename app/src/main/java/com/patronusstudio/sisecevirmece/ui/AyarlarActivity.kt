package com.patronusstudio.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.binding.SiseSecimiOnBinding
import com.patronusstudio.sisecevirmece.databinding.ActivityAyarlarBinding
import com.patronusstudio.sisecevirmece.util.extSayfaGecisi

class AyarlarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAyarlarBinding
    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ayarlar)

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-1818679104699845/3088388765"
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        binding.mainAyarlar = SiseSecimiOnBinding(binding.root) {
            reklamiGoster()
        }

        binding.include2.switchOyunSifirla.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                this.extSayfaGecisi(OyunSifirlaActivity::class.java)
            }
        }

        binding.include2.switchSoruEkle.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                this.extSayfaGecisi(FetchSoru::class.java)
            }
        }

    }

    fun reklamiGoster() {
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
        }
        mInterstitialAd.loadAd(AdRequest.Builder().build())
    }

    override fun onResume() {
        super.onResume()
//        if (OyunIslemleri.dialogButonunaBasildiMi) {
//            OyunIslemleri.dialogButonunaBasildiMi = false
        binding.include2.switchOyunSifirla.isChecked = false
        binding.mainAyarlar = SiseSecimiOnBinding(binding.root) {
            reklamiGoster()
//            }
        }
        binding.include2.switchSoruEkle.isChecked = false
    }


}
