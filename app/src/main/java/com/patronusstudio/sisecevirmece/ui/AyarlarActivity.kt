package com.patronusstudio.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.adapter.SiseSecimiAdapter
import com.patronusstudio.sisecevirmece.binding.SiseSecimiOnClickBinding
import com.patronusstudio.sisecevirmece.databinding.ActivityAyarlarBinding
import com.patronusstudio.sisecevirmece.util.OyunIslemleri
import com.patronusstudio.sisecevirmece.util.SharedVeriSaklama
import com.patronusstudio.sisecevirmece.util.extSayfaGecisi

class AyarlarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAyarlarBinding
    private lateinit var adapter: SiseSecimiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ayarlar)

        binding.mainAyarlar = SiseSecimiOnClickBinding(binding.root)

        binding.include2.switch1.setOnCheckedChangeListener { buttonView, isChecked ->

            if (isChecked) {
                this.extSayfaGecisi(OyunSifirlaActivity::class.java)
            }

        }


        val resimListesi =
            listOf(R.drawable.cola, R.drawable.whisky, R.drawable.wine, R.drawable.beer)
        val isimListesi = listOf("Kola", "Şarap", "Bira", "Viski")
        val secilenItem = mutableListOf(false, false, false, false)

        val sharedVeriSaklama = SharedVeriSaklama(this)
        var lastPosition = sharedVeriSaklama.getSiseTuru()
        secilenItem[lastPosition] = true
        OyunIslemleri.siseTuru = lastPosition


        val tiklandi = { currentPosition: Int ->
            adapter.updateData(lastPosition, currentPosition)
            lastPosition = currentPosition
            OyunIslemleri.siseTuru = lastPosition
            sharedVeriSaklama.updateSiseValue(lastPosition)
        }

        adapter = SiseSecimiAdapter(resimListesi, isimListesi, secilenItem, tiklandi)
        binding.includeUst.cardAyarlarRecyclerView.adapter = adapter
        binding.includeUst.cardAyarlarRecyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

    }

    override fun onResume() {
        super.onResume()
        if (OyunIslemleri.dialogButonunaBasildiMi) {
            OyunIslemleri.dialogButonunaBasildiMi = false
            binding.include2.switch1.isChecked = false
            binding.mainAyarlar = SiseSecimiOnClickBinding(binding.root)
        }
    }


}
