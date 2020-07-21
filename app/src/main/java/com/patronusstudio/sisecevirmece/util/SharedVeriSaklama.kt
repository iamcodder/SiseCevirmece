package com.patronusstudio.sisecevirmece.util

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.patronusstudio.sisecevirmece.enums.SharedPrefEnum

object SharedVeri

class SharedVeriSaklama(private val mContext: Context) {

    private val sharedPreferences by lazy {
        mContext.getSharedPreferences(
            SharedPrefEnum.FILE_PATH.value,
            MODE_PRIVATE
        )
    }

    fun isSharedPrefCreated(): Boolean = sharedPreferences.getBoolean(
        SharedPrefEnum.DB_CREATED.value,
        false
    )

    fun getDogrulukListValue(): Int = sharedPreferences.getInt(
        SharedPrefEnum.DB_DOGRULUK_SIZE.value,
        0
    )

    fun getCesaretListValue(): Int = sharedPreferences.getInt(
        SharedPrefEnum.DB_CESARET_SIZE.value,
        0
    )

    fun getDogrulukLastValue(): Int = sharedPreferences.getInt(
        SharedPrefEnum.DB_DOGRULUK_LAST_VALUE.value,
        0
    )

    fun getCesaretLastValue(): Int = sharedPreferences.getInt(
        SharedPrefEnum.DB_CESARET_LAST_VALUE.value,
        0
    )

    fun getSiseTuru(): Int = sharedPreferences.getInt(
        SharedPrefEnum.SISE_TURU.value,
        0
    )

    fun getToolTip(): Boolean = sharedPreferences.getBoolean(
        SharedPrefEnum.TOOLTIP.value,
        false
    )

    fun updateToolTip(gosterildiMi: Boolean) {
        sharedPreferences.edit()
            .putBoolean(
                SharedPrefEnum.TOOLTIP.value,
                gosterildiMi
            )
            .apply()
    }

    fun updateSiseValue(siseTuru: Int) {
        sharedPreferences.edit()
            .putInt(
                SharedPrefEnum.SISE_TURU.value,
                siseTuru
            )
            .apply()
    }


    fun updateDogrulukSize(
        dogrulukSize: Int
    ) {
        sharedPreferences.edit()
            .putInt(SharedPrefEnum.DB_DOGRULUK_SIZE.value, dogrulukSize)
            .apply()
    }

    fun updateCesaretSize(
        cesaretSize: Int
    ) {
        sharedPreferences.edit()
            .putInt(SharedPrefEnum.DB_CESARET_SIZE.value, cesaretSize)
            .apply()
    }

    fun updateLastValue(
        dogrulukLastValue: Int,
        cesaretLastValue: Int
    ) {
        sharedPreferences.edit()
            .putInt(
                SharedPrefEnum.DB_DOGRULUK_LAST_VALUE.value,
                dogrulukLastValue
            )
            .putInt(
                SharedPrefEnum.DB_CESARET_LAST_VALUE.value,
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
                SharedPrefEnum.DB_CREATED.value,
                isCreated
            )
            .putInt(
                SharedPrefEnum.DB_DOGRULUK_SIZE.value,
                dogrulukSize
            )
            .putInt(
                SharedPrefEnum.DB_CESARET_SIZE.value,
                cesaretSize
            )
            .putInt(
                SharedPrefEnum.DB_CESARET_LAST_VALUE.value,
                1
            )
            .putInt(
                SharedPrefEnum.DB_DOGRULUK_LAST_VALUE.value,
                1
            )
            .putInt(
                SharedPrefEnum.SISE_TURU.value,
                siseTuru
            )
            .putBoolean(
                SharedPrefEnum.TOOLTIP.value,
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