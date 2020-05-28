package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.abstracts.CesaretDatabase
import com.frappeclub.sisecevirmece.abstracts.DogrulukDatabase
import com.frappeclub.sisecevirmece.adapter.SorularAdapter
import com.frappeclub.sisecevirmece.databinding.ActivitySorulariGoruntuleBinding
import com.frappeclub.sisecevirmece.enums.DogrulukCesaret
import com.frappeclub.sisecevirmece.util.extSayfaGecisi

class SorulariGoruntuleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySorulariGoruntuleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sorulari_goruntule)

        val getBooleanIntent = intent.getBooleanExtra(DogrulukCesaret.DOGRULUK_CESARET.isim, false)
        val list =
            if (getBooleanIntent)
                DogrulukDatabase.getDatabaseManager(this).dogrulukDao().getAllModel()
            else CesaretDatabase.getDatabaseManager(this).cesaretDao().getAllModel()

        //TODO: Liste elemanı passlanacak
        val longClick = { position: Int ->

        }

        binding.cardSoruEkleButton.setOnClickListener {
            this.extSayfaGecisi(
                SoruEkleActivity::class.java,
                DogrulukCesaret.DOGRULUK_CESARET.isim,
                getBooleanIntent
            )
        }

        binding.dogrulukMu = getBooleanIntent
        binding.sorularRecycler.adapter = SorularAdapter(list, getBooleanIntent, longClick)
        binding.sorularRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
