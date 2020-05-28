package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.databinding.ActivitySecimEkraniBinding
import com.frappeclub.sisecevirmece.enums.DogrulukCesaret
import com.frappeclub.sisecevirmece.util.extSayfaGecisi
import com.frappeclub.sisecevirmece.util.extStatusBarColor
import kotlinx.android.synthetic.main.activity_secim_ekrani.view.*

class SecimEkraniActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySecimEkraniBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_secim_ekrani)

        this extStatusBarColor "#00000000"

        binding.cesaret = DogrulukCesaret.CESARET.isim
        binding.dogruluk = DogrulukCesaret.DOGRULUK.isim


        binding.cardviewGroup.imgCesaret.setOnClickListener {
            it.context.extSayfaGecisi(SoruActivity::class.java)
            finish()
        }

        binding.cardviewGroup.imgDogruluk.setOnClickListener {
            it.context.extSayfaGecisi(
                SoruActivity::class.java,
                true,
                DogrulukCesaret.DOGRULUK_CESARET.name
            )
            finish()
        }

    }

}
