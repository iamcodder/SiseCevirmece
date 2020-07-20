package com.patronusstudio.sisecevirmece.binding

import android.view.View
import com.patronusstudio.sisecevirmece.util.OyunIslemleri
import com.patronusstudio.sisecevirmece.util.SharedVeriSaklama

class SiseSecimiOnClickBinding(private val mainView: View) {

    private val model by lazy {
        SharedVeriSaklama(mainView.context)
    }

    init {
        val sise = OyunIslemleri.siseTuru
        setRadioButton(sise)
    }

    fun imageOnClick(view: View, siseTuru: Int) {
        setRadioButton(siseTuru)
        kayit(islemTuru = siseTuru)
    }

    private fun setRadioButton(siseTuru: Int) {
//        when (siseTuru) {
//            1 -> {
//                mainView.radioGroup.radioCola.isChecked = true
//            }
//            2 -> {
//                mainView.radioGroup.radioWine.isChecked = true
//            }
//            3 -> {
//                mainView.radioGroup.radioWhisky.isChecked = true
//            }
//            4 -> {
//                mainView.radioGroup.radioBottle.isChecked = true
//            }
//        }
    }


    private fun kayit(isFirstCall: Boolean = false, islemTuru: Int = 0) {

        if (isFirstCall) {
            val sharedSiseTuru = model.getSiseTuru()
            setRadioButton(sharedSiseTuru)
            OyunIslemleri.siseTuru = sharedSiseTuru
        } else {
            OyunIslemleri.siseTuru = islemTuru
            model.updateSiseValue(islemTuru)
        }

    }


}