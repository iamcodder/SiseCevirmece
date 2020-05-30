package com.patronusstudio.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.binding.SiseSecimiOnClickBinding
import com.patronusstudio.sisecevirmece.databinding.ActivityAyarlarBinding

class AyarlarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAyarlarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ayarlar)

        binding.mainAyarlar = SiseSecimiOnClickBinding(binding.root)

    }
}
