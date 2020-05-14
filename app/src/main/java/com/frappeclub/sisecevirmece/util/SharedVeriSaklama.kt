package com.frappeclub.sisecevirmece.util

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.frappeclub.sisecevirmece.enums.SharedPref

class SharedVeriSaklama(val mContext: Context) {

    private val sharedPreferences by lazy {
        mContext.getSharedPreferences(
            SharedPref.FILE_PATH.value,
            MODE_PRIVATE
        )
    }

    fun isSharedPrefCreated(): Boolean = sharedPreferences.getBoolean(
        SharedPref.DB_CREATED.value,
        false
    )

    fun putValue() {
        sharedPreferences.edit()
            .putBoolean(
                SharedPref.DB_CREATED.value,
                true
            )
            .apply()
    }

    fun clearSharedPref() {
        sharedPreferences.edit()
            .clear()
            .apply()
    }

}