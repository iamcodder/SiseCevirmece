package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frappeclub.sisecevirmece.databinding.ActivityDogrulukCesaretBinding
import com.frappeclub.sisecevirmece.util.extSayfaGecisi
import kotlinx.android.synthetic.main.activity_dogruluk_cesaret.view.*

class DogrulukCesaretActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDogrulukCesaretBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogrulukCesaretBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cardviewGroup.imgDogruluk.setOnClickListener {
            it.context.extSayfaGecisi(SoruActivity::class.java, true)
            finish()
        }

        binding.cardviewGroup.imgCesaret.setOnClickListener {
            it.context.extSayfaGecisi(SoruActivity::class.java)
            finish()
        }

    }

}
