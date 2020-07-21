package com.patronusstudio.sisecevirmece.binding

import android.content.Context
import android.view.View
import android.widget.Toast
import com.patronusstudio.sisecevirmece.abstracts.CesaretDatabase
import com.patronusstudio.sisecevirmece.abstracts.DogrulukDatabase
import com.patronusstudio.sisecevirmece.enums.DogrulukCesaretEnum
import com.patronusstudio.sisecevirmece.model.CesaretModel
import com.patronusstudio.sisecevirmece.model.DogrulukModel
import com.patronusstudio.sisecevirmece.ui.SoruEkleActivity
import com.patronusstudio.sisecevirmece.util.extSayfaGecisi
import kotlinx.android.synthetic.main.activity_sorulari_goruntule.view.*

class SorulariGoruntuleOnClickBinding(private val mContext: Context) {

    fun soruEkle(
        view: View,
        dogrulukMu: Boolean
    ) {
        view.context.extSayfaGecisi(
            SoruEkleActivity::class.java,
            DogrulukCesaretEnum.DOGRULUK_CESARET.isim,
            dogrulukMu
        )
    }

    fun sorulariKaristir(
        view: View,
        dogrulukMu: Boolean,
        dogrulukListesi: List<DogrulukModel>,
        cesaretListesi: List<CesaretModel>
    ) {

        if (dogrulukMu) {
            val newList: ArrayList<DogrulukModel> = dogrulukListesi as ArrayList<DogrulukModel>
            newList.shuffle()
            var number = 1
            newList.forEach {
                it.soruId = number
                number++
            }

            DogrulukDatabase.getDatabaseManager(mContext).dogrulukDao().deleteAllModel()
            DogrulukDatabase.getDatabaseManager(mContext).dogrulukDao().insertAll(newList)
        } else {
            val newList: ArrayList<CesaretModel> = cesaretListesi as ArrayList<CesaretModel>
            newList.shuffle()
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