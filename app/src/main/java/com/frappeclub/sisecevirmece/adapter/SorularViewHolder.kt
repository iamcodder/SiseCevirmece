package com.frappeclub.sisecevirmece.adapter

import androidx.recyclerview.widget.RecyclerView
import com.frappeclub.sisecevirmece.databinding.ItemviewSorulariGoruntuleBinding

class SorularViewHolder(val binding: ItemviewSorulariGoruntuleBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun setText(text: String) {
        binding.itemviewSoru.text = text
    }

    fun onLongClick(position: Int, longClick: (Int) -> Unit) {

        binding.itemviewSoru.setOnLongClickListener {
            longClick((position + 1))
            false
        }
    }

}