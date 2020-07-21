package com.patronusstudio.sisecevirmece.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.databinding.ActivityHomeItemButtonBinding
import com.patronusstudio.sisecevirmece.model.HomeButonModel

class HomeButtonAdapter(
    val modelList: ArrayList<HomeButonModel>,
    val clickedButton: (position: Int) -> Unit
) : RecyclerView.Adapter<HomeButonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeButonViewHolder {
        val rootView = DataBindingUtil.inflate<ActivityHomeItemButtonBinding>(
            LayoutInflater.from(parent.context)
            , R.layout.activity_home_item_button, parent, false
        )
        return HomeButonViewHolder(rootView)
    }

    override fun getItemCount(): Int = modelList.size

    override fun onBindViewHolder(holder: HomeButonViewHolder, position: Int) {
        holder.setText(modelList[position].butonIsmi)
        holder.setIcon(modelList[position].butonIconu)
        holder.setCardBdColor(modelList[position].butonBdColor)
        holder.onClickItem(position, clickedButton)
    }

    fun updateButonIcon(imageId: Int) {
        modelList[0].butonIconu = imageId
        this.notifyItemChanged(0)
    }
}