package com.patronusstudio.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.databinding.ActivitySorulariGoruntuleSecimEkraniBinding
import com.patronusstudio.sisecevirmece.enums.DogrulukCesaretEnum
import com.patronusstudio.sisecevirmece.util.extSayfaGecisi
import com.patronusstudio.sisecevirmece.util.extStatusBarColor

class SorulariGoruntuleSecimEkrani : AppCompatActivity() {

    private lateinit var binding: ActivitySorulariGoruntuleSecimEkraniBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_sorulari_goruntule_secim_ekrani)
        this extStatusBarColor "#00000000"

        binding.dogruluk = "Doğruluk"
        binding.cesaret = "Cesaret"

        binding.imgCesaret.setOnClickListener {
            this.extSayfaGecisi(
                SorulariGoruntuleActivity::class.java
            )
            finishActivity()
        }
        binding.imgDogruluk.setOnClickListener {
            this.extSayfaGecisi(
                SorulariGoruntuleActivity::class.java,
                DogrulukCesaretEnum.DOGRULUK_CESARET.isim,
                true
            )
            finishActivity()
        }
    }

    private fun finishActivity() {
        finish()
    }
}
