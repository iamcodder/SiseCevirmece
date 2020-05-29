package com.frappeclub.sisecevirmece.binding

import android.content.Context
import android.view.View
import android.widget.Toast
import com.frappeclub.sisecevirmece.abstracts.CesaretDatabase
import com.frappeclub.sisecevirmece.abstracts.DogrulukDatabase
import com.frappeclub.sisecevirmece.enums.DogrulukCesaret
import com.frappeclub.sisecevirmece.model.CesaretModel
import com.frappeclub.sisecevirmece.model.DogrulukModel
import com.frappeclub.sisecevirmece.ui.SoruEkleActivity
import com.frappeclub.sisecevirmece.util.extSayfaGecisi
import kotlinx.android.synthetic.main.activity_sorulari_goruntule.view.*

class SorulariGoruntuleOnClickBinding(private val mContext: Context) {

    fun soruEkle(
        view: View,
        dogrulukMu: Boolean
    ) {
        view.context.extSayfaGecisi(
            SoruEkleActivity::class.java,
            DogrulukCesaret.DOGRULUK_CESARET.isim,
            dogrulukMu
        )
    }

    fun <T> sorulariKaristir(
        view: View,
        dogrulukMu: Boolean,
        list: List<T>
    ) {

        if (dogrulukMu) {
            val newList = (list as MutableList<DogrulukModel>).apply {
                this.shuffle()
            }
            var number = 1
            newList.forEach {
                it.soruId = number
                number++
            }

            DogrulukDatabase.getDatabaseManager(mContext).dogrulukDao().deleteAllModel()
            DogrulukDatabase.getDatabaseManager(mContext).dogrulukDao().insertAll(newList)
        } else {
            val newList = (list as MutableList<CesaretModel>).apply {
                this.shuffle()
            }
            var number = 1
            newList.forEach {
                it.soruId = number
                number++
            }
            CesaretDatabase.getDatabaseManager(mContext).cesaretDao().deleteAllModel()
            CesaretDatabase.getDatabaseManager(mContext).cesaretDao().insertAll(newList)
        }

        view.rootView.sorularRecycler.adapter?.notifyDataSetChanged() ?: Toast.makeText(
            mContext,
            "Hata",
            Toast.LENGTH_SHORT
        ).show()

    }
}