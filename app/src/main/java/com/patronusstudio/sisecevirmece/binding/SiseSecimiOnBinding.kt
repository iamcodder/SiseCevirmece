package com.patronusstudio.sisecevirmece.binding

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.patronusstudio.sisecevirmece.adapter.SiseSecimiAdapter
import com.patronusstudio.sisecevirmece.enums.SiseSecimiEnum
import com.patronusstudio.sisecevirmece.util.OyunIslemleri
import com.patronusstudio.sisecevirmece.util.SharedVeriSaklama
import kotlinx.android.synthetic.main.activity_ayarlar.view.*
import kotlinx.android.synthetic.main.card_ayarlar_sise_turu.view.*


class SiseSecimiOnBinding(
    private val mainView: View,
    val tiklandi: (tiklandiMi: Boolean) -> Unit
) {

    private val sharedVeriSaklama by lazy {
        SharedVeriSaklama(mainView.context)
    }
    private lateinit var adapter: SiseSecimiAdapter


    init {
        recyclerSet()
    }


    private fun recyclerSet() {
        val resimListesi =
            listOf(
                SiseSecimiEnum.Gazoz.getSiseImage(),
                SiseSecimiEnum.Kola.getSiseImage(),
                SiseSecimiEnum.Sarap.getSiseImage(),
                SiseSecimiEnum.Bira.getSiseImage(),
                SiseSecimiEnum.EskiSarap.getSiseImage(),
                SiseSecimiEnum.Sampanya.getSiseImage(),
                SiseSecimiEnum.Cayci.getSiseImage()
            )

        val secilenItem = mutableListOf(false, false, false, false, false, false, false)

        var lastPosition = sharedVeriSaklama.getSiseTuru()
        secilenItem[lastPosition] = true
        OyunIslemleri.siseTuru = lastPosition

        val tiklandi = { currentPosition: Int ->
            adapter.updateData(lastPosition, currentPosition)
            lastPosition = currentPosition
            kayit(islemTuru = lastPosition)
            tiklandi(true)
        }

        adapter = SiseSecimiAdapter(resimListesi, secilenItem, tiklandi)

        val layoutManager = LinearLayoutManager(mainView.context, RecyclerView.HORIZONTAL, false)
        layoutManager.isSmoothScrollbarEnabled = true

        mainView.includeUst.cardAyarlarRecyclerView.adapter = adapter
        mainView.includeUst.cardAyarlarRecyclerView.layoutManager = layoutManager
        mainView.includeUst.cardAyarlarRecyclerView.scrollToPosition(lastPosition - 1)

    }


    private fun kayit(isFirstCall: Boolean = false, islemTuru: Int = 0) {

        if (isFirstCall) {
            val sharedSiseTuru = sharedVeriSaklama.getSiseTuru()
            OyunIslemleri.siseTuru = sharedSiseTuru
        } else {
            OyunIslemleri.siseTuru = islemTuru
            sharedVeriSaklama.updateSiseValue(islemTuru)
        }

    }


}