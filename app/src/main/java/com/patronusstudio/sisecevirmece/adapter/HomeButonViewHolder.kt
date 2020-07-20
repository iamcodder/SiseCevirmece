package com.patronusstudio.sisecevirmece.adapter

import androidx.recyclerview.widget.RecyclerView
import com.patronusstudio.sisecevirmece.databinding.ActivityHomeItemButtonBinding

class HomeButonViewHolder(val binding: ActivityHomeItemButtonBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun setText(butonName: String) {
        binding.homeButtonName.text = butonName
    }

    fun setIcon(iconId: Int) {
        binding.homeButtonImg.setImageResource(iconId)
    }

    fun setCardBdColor(bdColor: Int) {
        binding.imgStore.setCardBackgroundColor(bdColor)
    }

    fun onClickItem(position: Int, click: (position: Int) -> Unit) {
        binding.imgStore.setOnClickListener {
            click(position)
        }
    }

}