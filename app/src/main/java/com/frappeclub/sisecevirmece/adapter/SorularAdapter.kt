package com.frappeclub.sisecevirmece.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.databinding.ItemviewSorulariGoruntuleBinding
import com.frappeclub.sisecevirmece.model.CesaretModel
import com.frappeclub.sisecevirmece.model.DogrulukModel

class SorularAdapter<T>(
    val sorularListesi: List<T>,
    val dogrulukMu: Boolean = false,
    val longClick: (Int) -> Unit
) : RecyclerView.Adapter<SorularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SorularViewHolder {

        val binding = DataBindingUtil.inflate<ItemviewSorulariGoruntuleBinding>(
            LayoutInflater.from(parent.context),
            R.layout.itemview_sorulari_goruntule, parent, false
        )
        return SorularViewHolder(binding)
    }

    override fun getItemCount(): Int = sorularListesi.size


    override fun onBindViewHolder(holder: SorularViewHolder, position: Int) {
        if (dogrulukMu) holder.setText((sorularListesi[position] as DogrulukModel).soru)
        else holder.setText((sorularListesi[position] as CesaretModel).soru)
        holder.onLongClick(position, longClick)
    }

}