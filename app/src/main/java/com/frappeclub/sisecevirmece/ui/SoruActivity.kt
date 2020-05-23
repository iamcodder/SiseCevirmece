package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.abstracts.CesaretDatabase
import com.frappeclub.sisecevirmece.abstracts.DogrulukDatabase
import com.frappeclub.sisecevirmece.databinding.ActivitySoruBinding
import com.frappeclub.sisecevirmece.enums.DogrulukCesaret
import com.frappeclub.sisecevirmece.util.ListSize
import com.frappeclub.sisecevirmece.util.SharedVeriSaklama
import com.frappeclub.sisecevirmece.util.extLogMessage
import kotlinx.android.synthetic.main.card_alt_cevap.view.*
import kotlinx.android.synthetic.main.card_ust_cevap.view.*

class SoruActivity : AppCompatActivity() {

    private var TAG = this.javaClass.simpleName

    private lateinit var binding: ActivitySoruBinding
    private lateinit var gosterilenSoru: String
    private var getBooleanIntent: Boolean = false
    private val cesaretDatabase by lazy {
        CesaretDatabase.getDatabaseManager(this)
    }
    private val dogrulukDatabase by lazy {
        DogrulukDatabase.getDatabaseManager(this)
    }

    private val model by lazy {
        SharedVeriSaklama(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_soru)

        getBooleanIntent = intent.getBooleanExtra(DogrulukCesaret.DOGRULUK_CESARET.name, false)


        soruSayisiKontrol(getBooleanIntent)
        bindingText()
        sharedGuncelle()


        binding.ortaCard.soru_cevaplandi.setOnClickListener {
            finish()
        }
        binding.ortaCard.soru_soruDegistir.setOnClickListener {
            soruSayisiKontrol(getBooleanIntent)
            bindingText()
            sharedGuncelle()
        }
        binding.altCard.soru_benSoracagim.setOnClickListener {
            finish()
        }
    }


    private fun bindingText() {
        binding.ustCard.cardSoru.text = gosterilenSoru
    }

    private fun soruSayisiKontrol(dogrulukMu: Boolean) {
        if (ListSize.cesaretLastValue > ListSize.cesaretSize) {
            cesaretDatabase.cesaretDao().updateAll()
            ListSize.cesaretLastValue = 1
            TAG extLogMessage "C Güncellendi"
        } else if (ListSize.dogrulukLastValue > ListSize.dogrulukSize) {
            dogrulukDatabase.dogrulukDao().updateAll()
            ListSize.dogrulukLastValue = 1
            TAG extLogMessage "D Güncellendi"
        }
        soruGetir(dogrulukMu)
    }

    private fun soruGetir(dogrulukMu: Boolean) {
        if (dogrulukMu) {
            val model = dogrulukDatabase.dogrulukDao().getModel(ListSize.dogrulukLastValue)
            ListSize.dogrulukLastValue++
            model.sorulduMu = true
            dogrulukDatabase.dogrulukDao().update(model)
            gosterilenSoru = model.soru

            TAG extLogMessage "D : " + model.soruId

        } else {
            val model = cesaretDatabase.cesaretDao().getModel(ListSize.cesaretLastValue)
            ListSize.cesaretLastValue++
            model.sorulduMu = true
            cesaretDatabase.cesaretDao().update(model)
            gosterilenSoru = model.soru
            TAG extLogMessage "C : " + model.soruId
        }
    }

    private fun sharedGuncelle() {

        model.updateValue(
            ListSize.dogrulukLastValue,
            ListSize.cesaretLastValue
        )
    }

}
