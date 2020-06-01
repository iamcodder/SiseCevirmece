package com.patronusstudio.sisecevirmece.util

import android.content.Context
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.model.CesaretModel
import com.patronusstudio.sisecevirmece.model.DogrulukModel


class SoruEkleme(private val mContext: Context) {
    private val _cesaretList = mutableListOf<CesaretModel>()
    private val _dogrulukList = mutableListOf<DogrulukModel>()

    val cesaretListSize
        get() = _cesaretList.size

    val dogrulukListSize
        get() = _dogrulukList.size

    fun cesaretListesiEkleme(): List<CesaretModel> {
        val cesaretListesi = mContext.resources.getStringArray(R.array.cesaretListesi)
        cesaretListesi.forEach {
            _cesaretList.add(CesaretModel(soru = it))
        }
        _cesaretList.shuffle()
        return _cesaretList

    }

    fun dogrulukListesiEkleme(): List<DogrulukModel> {
        val dogrulukListesi = mContext.resources.getStringArray(R.array.dogrulukListesi)
        dogrulukListesi.forEach {
            _dogrulukList.add(DogrulukModel(soru = it))
        }
        _dogrulukList.shuffle()
        return _dogrulukList
    }


}