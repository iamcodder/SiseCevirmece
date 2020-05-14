package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.databinding.ActivitySoruBinding
import com.frappeclub.sisecevirmece.enums.DogrulukCesaret
import kotlinx.android.synthetic.main.card_alt_cevap.view.*
import kotlinx.android.synthetic.main.card_ust_cevap.view.*

class SoruActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySoruBinding
    private lateinit var gosterilenSoru: String
    private var getBooleanIntent: Boolean = false
    private lateinit var liste: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_soru)
//Todo: Seçime göre soru getirelecek
        //true doğruluk
        //false cesaret
        getBooleanIntent = intent.getBooleanExtra(DogrulukCesaret.DOGRULUK_CESARET.name, false)


        //gosterilenSoru dbden çekilen soru olacan

        //binding.ustCard.cardSoru.text = gosterilenSoru

        binding.ortaCard.soru_cevaplandi.setOnClickListener {
            soruSil()
            soruDegistir()
        }

        binding.ortaCard.soru_soruDegistir.setOnClickListener {
            soruSil()
            soruDegistir()
        }
        binding.altCard.soru_benSoracagim.setOnClickListener {
            soruSil()
            soruDegistir()
        }
    }

    //Todo: Db hazır.Fonksiyonları doldur.
    private fun soruSil() {
    }

    private fun soruDegistir() {

    }
}
