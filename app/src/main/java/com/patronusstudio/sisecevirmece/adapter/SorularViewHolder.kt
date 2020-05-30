package com.patronusstudio.sisecevirmece.adapter

import androidx.recyclerview.widget.RecyclerView
import com.patronusstudio.sisecevirmece.databinding.ItemviewSorulariGoruntuleBinding

class SorularViewHolder(val binding: ItemviewSorulariGoruntuleBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun setText(text: String) {
        binding.itemviewSoru.text = text
    }

    fun onLongClick(position: Int, longClick: (Int) -> Unit) {

        binding.itemviewSoru.setOnLongClickListener {
            longClick((position))
            false
        }
    }

}