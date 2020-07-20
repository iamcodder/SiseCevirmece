package com.patronusstudio.sisecevirmece.util

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.patronusstudio.sisecevirmece.enums.SharedPref

object SharedVeri

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
        0
    )

    fun getToolTip(): Boolean = sharedPreferences.getBoolean(
        SharedPref.TOOLTIP.value,
        false
    )

    fun updateToolTip(gosterildiMi: Boolean) {
        sharedPreferences.edit()
            .putBoolean(
                SharedPref.TOOLTIP.value,
                gosterildiMi
            )
            .apply()
    }

    fun updateSiseValue(siseTuru: Int) {
        sharedPreferences.edit()
            .putInt(
                SharedPref.SISE_TURU.value,
                siseTuru
            )
            .apply()
    }


    fun updateDogrulukSize(
        dogrulukSize: Int
    ) {
        sharedPreferences.edit()
            .putInt(SharedPref.DB_DOGRULUK_SIZE.value, dogrulukSize)
            .apply()
    }

    fun updateCesaretSize(
        cesaretSize: Int
    ) {
        sharedPreferences.edit()
            .putInt(SharedPref.DB_CESARET_SIZE.value, cesaretSize)
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
            .putBoolean(
                SharedPref.TOOLTIP.value,
                false
            )
            .apply()
    }

    fun clearSharedPref() {
        sharedPreferences.edit()
            .clear()
            .apply()
    }
}