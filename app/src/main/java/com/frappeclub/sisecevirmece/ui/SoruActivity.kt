package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.databinding.ActivitySoruBinding
import com.frappeclub.sisecevirmece.enums.Veri
import com.frappeclub.sisecevirmece.mock.Questions
import kotlinx.android.synthetic.main.card_alt_cevap.view.*
import kotlinx.android.synthetic.main.card_soru.view.cardSoru
import kotlinx.android.synthetic.main.card_ust_cevap.view.*

class SoruActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySoruBinding
    private lateinit var gosterilenSoru: String
    private var getBooleanIntent: Boolean = false
    private lateinit var liste: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_soru)
//Todo: Bu sınıf karışık.Burası temizlenecek.
        getBooleanIntent = intent.getBooleanExtra(Veri.DOGRULUK_CESARET.name, false)

        liste = if (getBooleanIntent) {
            Questions.dogrulukSoruListesi
        } else {
            Questions.cesaretSoruListesi
        }
        gosterilenSoru = Questions.getSoru(liste as ArrayList<String>)

        binding.ustCard.cardSoru.text = gosterilenSoru

        binding.ortaCard.soru_cevaplandi.setOnClickListener {
            soruSil()
            soruDegistir()
        }

        binding.ortaCard.soru_soruDegistir.setOnClickListener {
            soruSil()
            soruDegistir(true)
        }


        binding.altCard.soru_benSoracagim.setOnClickListener {
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
