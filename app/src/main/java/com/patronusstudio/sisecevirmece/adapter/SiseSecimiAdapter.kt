package com.patronusstudio.sisecevirmece.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.databinding.CardAyarlarItemSiseTuruBinding

class SiseSecimiAdapter(
    val imageList: List<Int>,
    var secilenItem: MutableList<Boolean>,
    val siseSecimi: (Int) -> Unit
) : RecyclerView.Adapter<SiseSecimiViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiseSecimiViewHolder {

        val binding = DataBindingUtil.inflate<CardAyarlarItemSiseTuruBinding>(
            LayoutInflater.from(parent.context),
            R.layout.card_ayarlar_item_sise_turu, parent, false
        )
        return SiseSecimiViewHolder(binding)
    }

    override fun getItemCount(): Int = imageList.size


    override fun onBindViewHolder(holder: SiseSecimiViewHolder, position: Int) {
        holder.setImage(imageList[position])
        holder.setRadio(secilenItem[position])
        holder.onClick(position, siseSecimi)
    }

    fun updateData(lastPosition: Int, currentPosition: Int) {
        secilenItem[lastPosition] = false
        secilenItem[currentPosition] = true
        this.notifyItemChanged(currentPosition)
        this.notifyItemChanged(lastPosition)
    }

}