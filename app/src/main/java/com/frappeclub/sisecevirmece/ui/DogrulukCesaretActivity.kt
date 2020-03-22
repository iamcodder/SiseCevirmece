package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frappeclub.sisecevirmece.databinding.ActivityDogrulukCesaretBinding
import com.frappeclub.sisecevirmece.util.extSayfaGecisi

class DogrulukCesaretActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDogrulukCesaretBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogrulukCesaretBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cardviewGroup.setOnClickListener {
            it.context extSayfaGecisi SoruActivity::class.java
            finish()
        }

    }

}
