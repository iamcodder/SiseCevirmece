package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.binding.SiseSecimiOnClickBinding
import com.frappeclub.sisecevirmece.databinding.ActivityAyarlarBinding

class AyarlarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAyarlarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ayarlar)

        binding.mainAyarlar = SiseSecimiOnClickBinding(binding.root)

    }
}
