package com.frappeclub.sisecevirmece.binding

import android.content.Context
import com.frappeclub.sisecevirmece.abstracts.CesaretDatabase
import com.frappeclub.sisecevirmece.abstracts.DogrulukDatabase
import com.frappeclub.sisecevirmece.model.CesaretModel
import com.frappeclub.sisecevirmece.model.DogrulukModel

class SoruDuzenleOnClickBinding<Model>(
    private val mContext: Context,
    private val getBooleanIntent: Boolean,
    private val model: Model,
    private val bitir: (String) -> Unit
) {

    fun soruSil() {
        if (getBooleanIntent) {
            val mDatabase = DogrulukDatabase.getDatabaseManager(mContext).dogrulukDao()
            mDatabase.delete(model as DogrulukModel)
        } else {
            val mDatabase = CesaretDatabase.getDatabaseManager(mContext).cesaretDao()
            mDatabase.delete(model as CesaretModel)
        }
        bitir("Soru Silindi")
    }

}