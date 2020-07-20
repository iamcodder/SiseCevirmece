package com.patronusstudio.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.binding.SiseSecimiOnBinding
import com.patronusstudio.sisecevirmece.databinding.ActivityAyarlarBinding
import com.patronusstudio.sisecevirmece.util.OyunIslemleri
import com.patronusstudio.sisecevirmece.util.extSayfaGecisi

class AyarlarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAyarlarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ayarlar)

        binding.mainAyarlar = SiseSecimiOnBinding(binding.root)

        binding.include2.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                this.extSayfaGecisi(OyunSifirlaActivity::class.java)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (OyunIslemleri.dialogButonunaBasildiMi) {
            OyunIslemleri.dialogButonunaBasildiMi = false
            binding.include2.switch1.isChecked = false
            binding.mainAyarlar = SiseSecimiOnBinding(binding.root)
        }
    }


}
