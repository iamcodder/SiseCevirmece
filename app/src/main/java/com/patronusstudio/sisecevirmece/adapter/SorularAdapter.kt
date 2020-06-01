package com.patronusstudio.sisecevirmece.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.databinding.ItemviewSorulariGoruntuleBinding
import com.patronusstudio.sisecevirmece.model.CesaretModel
import com.patronusstudio.sisecevirmece.model.DogrulukModel

class SorularAdapter(
    private val dogrulukSoruListesi: List<DogrulukModel>,
    private val cesaretSoruListesi: List<CesaretModel>,
    private val dogrulukMu: Boolean = false,
    private val longClick: (Int) -> Unit
) : RecyclerView.Adapter<SorularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SorularViewHolder {

        val binding = DataBindingUtil.inflate<ItemviewSorulariGoruntuleBinding>(
            LayoutInflater.from(parent.context),
            R.layout.itemview_sorulari_goruntule, parent, false
        )
        return SorularViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (dogrulukMu) dogrulukSoruListesi.size
        else cesaretSoruListesi.size
    }


    override fun onBindViewHolder(holder: SorularViewHolder, position: Int) {
        if (dogrulukMu) holder.setText(dogrulukSoruListesi[position].soru)
        else holder.setText(cesaretSoruListesi[position].soru)
        holder.onLongClick(position, longClick)
    }

}