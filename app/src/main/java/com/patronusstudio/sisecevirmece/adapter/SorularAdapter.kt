package com.patronusstudio.sisecevirmece.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.databinding.ItemviewSorulariGoruntuleBinding
import com.patronusstudio.sisecevirmece.model.CesaretModel
import com.patronusstudio.sisecevirmece.model.DogrulukModel
import com.patronusstudio.sisecevirmece.util.OyunIslemleri

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

    fun deleteData() {
        val index = OyunIslemleri.degisenSoruIndexi
        if (dogrulukMu) (dogrulukSoruListesi as ArrayList).removeAt(index)
        else (cesaretSoruListesi as ArrayList).removeAt(index)
        val listSize =
            if (dogrulukSoruListesi.size > cesaretSoruListesi.size) dogrulukSoruListesi.size
            else cesaretSoruListesi.size

        notifyItemRemoved(index)
        notifyItemRangeChanged(index, listSize)

    }

    fun addData() {
        val listSize = if (dogrulukMu) dogrulukSoruListesi.size
        else cesaretSoruListesi.size

        val soru = OyunIslemleri.guncellenenSoru

        if (dogrulukMu) (dogrulukSoruListesi as ArrayList).add(
            listSize,
            DogrulukModel(listSize, soru, false)
        )
        else (cesaretSoruListesi as ArrayList).add(listSize, CesaretModel(listSize, soru, false))

        notifyItemInserted(listSize)
    }

    fun updateData() {
        val getSoru = OyunIslemleri.guncellenenSoru
        val index = OyunIslemleri.degisenSoruIndexi

        if (dogrulukMu) {
            val model = dogrulukSoruListesi[index]
            model.soru = getSoru
            (dogrulukSoruListesi as ArrayList)[index] = model
        } else {
            val model = cesaretSoruListesi[index]
            model.soru = getSoru
            (cesaretSoruListesi as ArrayList)[index] = model
        }
        notifyItemChanged(index)
    }


}
