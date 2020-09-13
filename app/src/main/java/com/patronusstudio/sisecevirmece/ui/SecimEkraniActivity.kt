package com.patronusstudio.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.databinding.ActivitySecimEkraniBinding
import com.patronusstudio.sisecevirmece.enums.DogrulukCesaretEnum
import com.patronusstudio.sisecevirmece.util.extSayfaGecisi
import com.patronusstudio.sisecevirmece.util.extStatusBarColor
import kotlinx.android.synthetic.main.activity_secim_ekrani.view.*

class SecimEkraniActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySecimEkraniBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_secim_ekrani)

        this extStatusBarColor "#00000000"


        binding.cardviewGroup.imgCesaret.setOnClickListener {
            it.context.extSayfaGecisi(SoruActivity::class.java)
            finish()
        }

        binding.cardviewGroup.imgDogruluk.setOnClickListener {
            it.context.extSayfaGecisi(
                SoruActivity::class.java,
                DogrulukCesaretEnum.DOGRULUK_CESARET.isim,
                true
            )
            finish()
        }

    }

}
