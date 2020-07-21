package com.patronusstudio.sisecevirmece.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.patronusstudio.sisecevirmece.databinding.CardAyarlarItemSiseTuruBinding

class SiseSecimiViewHolder(val binding: CardAyarlarItemSiseTuruBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun setImage(resId: Int) {
        Glide.with(binding.root.context).load(resId).into(binding.itemSiseTuru)
    }

    fun setRadio(isSelected: Boolean) {
        if (isSelected) {
            binding.itemSiseRadio.visibility = View.VISIBLE
        } else {
            binding.itemSiseRadio.visibility = View.INVISIBLE
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