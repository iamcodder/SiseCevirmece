package com.frappeclub.sisecevirmece.util

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.frappeclub.sisecevirmece.enums.SharedPref

class SharedVeriSaklama(private val mContext: Context) {

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

    fun getDogrulukListValue(): Int = sharedPreferences.getInt(
        SharedPref.DB_DOGRULUK_SIZE.value,
        0
    )

    fun getCesaretListValue(): Int = sharedPreferences.getInt(
        SharedPref.DB_CESARET_SIZE.value,
        0
    )

    fun getDogrulukLastValue(): Int = sharedPreferences.getInt(
        SharedPref.DB_DOGRULUK_LAST_VALUE.value,
        0
    )

    fun getCesaretLastValue(): Int = sharedPreferences.getInt(
        SharedPref.DB_CESARET_LAST_VALUE.value,
        0
    )

    fun getSiseTuru(): Int = sharedPreferences.getInt(
        SharedPref.SISE_TURU.value,
        1
    )

    fun updateSiseValue(siseTuru: Int) {
        sharedPreferences.edit()
            .putInt(
                SharedPref.SISE_TURU.value,
                siseTuru
            )
            .apply()
    }

    fun updateLastValue(
        dogrulukLastValue: Int,
        cesaretLastValue: Int
    ) {
        sharedPreferences.edit()
            .putInt(
                SharedPref.DB_DOGRULUK_LAST_VALUE.value,
                dogrulukLastValue
            )
            .putInt(
                SharedPref.DB_CESARET_LAST_VALUE.value,
                cesaretLastValue
            )
            .apply()
    }

    fun putValueForFirstStarted(
        isCreated: Boolean,
        dogrulukSize: Int,
        cesaretSize: Int,
        siseTuru: Int
    ) {
        sharedPreferences.edit()
            .putBoolean(
                SharedPref.DB_CREATED.value,
                isCreated
            )
            .putInt(
                SharedPref.DB_DOGRULUK_SIZE.value,
                dogrulukSize
            )
            .putInt(
                SharedPref.DB_CESARET_SIZE.value,
                cesaretSize
            )
            .putInt(
                SharedPref.DB_CESARET_LAST_VALUE.value,
                1
            )
            .putInt(
                SharedPref.DB_DOGRULUK_LAST_VALUE.value,
                1
            )
            .putInt(
                SharedPref.SISE_TURU.value,
                siseTuru
            )
            .apply()
    }

}