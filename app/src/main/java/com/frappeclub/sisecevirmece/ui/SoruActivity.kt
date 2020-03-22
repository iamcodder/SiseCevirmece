package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frappeclub.sisecevirmece.databinding.ActivitySoruBinding
import com.frappeclub.sisecevirmece.util.extLogMessage

class SoruActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySoruBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySoruBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ortaCard.soruCevaplandi.setOnClickListener {
            finish()
            "soru cevaplandı".extLogMessage()
        }

        binding.ortaCard.soruSoruDegistir.setOnClickListener {
            "soru değiştir".extLogMessage()
        }

        binding.altCard.soruBenSoracagim.setOnClickListener {
            "ben soracağım".extLogMessage()
        }

    }
}
