package com.patronusstudio.sisecevirmece.binding

import android.content.Context
import android.view.View
import com.patronusstudio.sisecevirmece.abstracts.CesaretDatabase
import com.patronusstudio.sisecevirmece.abstracts.DogrulukDatabase
import com.patronusstudio.sisecevirmece.model.CesaretModel
import com.patronusstudio.sisecevirmece.model.DogrulukModel
import kotlinx.android.synthetic.main.activity_soru_ekle.view.*

class SoruDuzenleOnClickBinding<Model>(
    private val mContext: Context,
    private val getBooleanIntent: Boolean,
    private val model: Model,
    private val bitir: (String, Boolean) -> Unit
) {

    fun soruSil() {
        if (getBooleanIntent) {
            val mDatabase = DogrulukDatabase.getDatabaseManager(mContext).dogrulukDao()
            mDatabase.delete(model as DogrulukModel)
        } else {
            val mDatabase = CesaretDatabase.getDatabaseManager(mContext).cesaretDao()
            mDatabase.delete(model as CesaretModel)
        }
        bitir("Soru Silindi", true)
    }

    fun soruGuncelle(view: View) {
        val yeniSoru = view.rootView.edxGirilenSoru.text

        if (!yeniSoru.isNullOrBlank()) {

            if (getBooleanIntent) {
                val mDatabase = DogrulukDatabase.getDatabaseManager(mContext).dogrulukDao()
                (model as DogrulukModel).soru = yeniSoru.toString()
                mDatabase.update(model)
            } else {
                val mDatabase = CesaretDatabase.getDatabaseManager(mContext).cesaretDao()
                (model as CesaretModel).soru = yeniSoru.toString()
                mDatabase.update(model)
            }
            bitir("Soru Güncellendi", true)
        } else bitir("Hatayla karşılaşıldı.Tekrar deneyiniz.", false)

    }

}