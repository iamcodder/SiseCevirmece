package com.patronusstudio.sisecevirmece.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.patronusstudio.sisecevirmece.databinding.CardAyarlarItemSiseTuruBinding

class SiseSecimiViewHolder(val binding: CardAyarlarItemSiseTuruBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun setImage(resId: Int) {
        Glide.with(binding.root.context).load(resId).into(binding.itemSiseTuru)
    }

    fun setRadioText(isim: String) {
        binding.itemSiseRadio.text = isim
    }

    fun setRadio(isSelected: Boolean) {
        if (isSelected) {
            binding.itemSiseRadio.isSelected = true
            binding.itemSiseRadio.isChecked = true
        } else {
            binding.itemSiseRadio.isSelected = false
            binding.itemSiseRadio.isChecked = false
        }
    }

    fun onClick(position: Int, dondur: (Int) -> Unit) {
        binding.itemSiseRadio.setOnClickListener {
            dondur(position)
        }
        binding.itemSiseTuru.setOnClickListener {
            dondur(position)
        }
    }

}