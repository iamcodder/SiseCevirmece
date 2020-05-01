package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frappeclub.sisecevirmece.databinding.ActivitySoruBinding
import com.frappeclub.sisecevirmece.enums.Veri
import com.frappeclub.sisecevirmece.mock.Questions

class SoruActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySoruBinding
    private lateinit var gosterilenSoru: String
    private var getBooleanIntent: Boolean = false
    private lateinit var liste: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySoruBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getBooleanIntent = intent.getBooleanExtra(Veri.DOGRULUK_CESARET.name, false)

        liste = if (getBooleanIntent) {
            Questions.dogrulukSoruListesi
        } else {
            Questions.cesaretSoruListesi
        }
        gosterilenSoru = Questions.getSoru(liste as ArrayList<String>)

        binding.ustCard.cardSoru.text = gosterilenSoru

        binding.ortaCard.soruCevaplandi.setOnClickListener {
            soruSil()
            soruDegistir()
        }

        binding.ortaCard.soruSoruDegistir.setOnClickListener {
            soruSil()
            soruDegistir(true)
        }

        binding.altCard.soruBenSoracagim.setOnClickListener {
            soruSil()
            soruDegistir()
        }


    }

    fun soruSil() {
        Questions.removeSoru(liste as ArrayList<String>)
    }

    fun soruDegistir(degistir: Boolean = false) {

        if (degistir) {
            gosterilenSoru = Questions.getSoru(liste as ArrayList<String>)
            binding.ustCard.cardSoru.text = gosterilenSoru
            return
        }
        finish()
    }
}
