package com.patronusstudio.sisecevirmece.util

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.patronusstudio.sisecevirmece.enums.SharedPrefEnum

class SharedVeriSaklama(private val mContext: Context) {

    private val sharedPreferences by lazy {
        mContext.getSharedPreferences(
            SharedPrefEnum.FILE_PATH.getValue(),
            MODE_PRIVATE
        )
    }

    fun isSharedPrefCreated(): Boolean = sharedPreferences.getBoolean(
        SharedPrefEnum.DB_CREATED.getValue(),
        false
    )

    fun getDogrulukListValue(): Int = sharedPreferences.getInt(
        SharedPrefEnum.DB_DOGRULUK_SIZE.getValue(),
        0
    )

    fun getCesaretListValue(): Int = sharedPreferences.getInt(
        SharedPrefEnum.DB_CESARET_SIZE.getValue(),
        0
    )

    fun getDogrulukSize(): Int = sharedPreferences.getInt(
        SharedPrefEnum.DB_DOGRULUK_LAST_VALUE.getValue(),
        0
    )

    fun getCesaretSize(): Int = sharedPreferences.getInt(
        SharedPrefEnum.DB_CESARET_LAST_VALUE.getValue(),
        0
    )

    fun getDogrulukEklenenSize(): Int = sharedPreferences.getInt(
        SharedPrefEnum.DB_DOGRULUK_EKLENEN_SIZE.getValue(),
        0
    )

    fun getCesaretEklenenSize(): Int = sharedPreferences.getInt(
        SharedPrefEnum.DB_CESARET_EKLENEN_SIZE.getValue(),
        0
    )

    fun getDogrulukEklenenLastValue(): Int = sharedPreferences.getInt(
        SharedPrefEnum.DB_DOGRULUK_EKLENEN_LAST_VALUE.getValue(),
        0
    )

    fun getCesaretEklenenLastValue(): Int = sharedPreferences.getInt(
        SharedPrefEnum.DB_CESARET_EKLENEN_LAST_VALUE.getValue(),
        0
    )

    fun getSiseTuru(): Int = sharedPreferences.getInt(
        SharedPrefEnum.SISE_TURU.getValue(),
        0
    )

    fun getToolTip(): Boolean = sharedPreferences.getBoolean(
        SharedPrefEnum.TOOLTIP.getValue(),
        false
    )

    fun getToplamSoruPaketi(): String? = sharedPreferences.getString(
        SharedPrefEnum.TOPLAM_SORU_PAKETI.getValue(),
        "0"
    )

    fun getDogrulukSoruPaketi(): String? = sharedPreferences.getString(
        SharedPrefEnum.DOGRULUK_SORU_PAKETI.getValue(),
        "0"
    )

    fun getCesaretSoruPaketi(): String? = sharedPreferences.getString(
        SharedPrefEnum.CESARET_SORU_PAKETI.getValue(),
        "0"
    )

    fun getLanguage(): String? = sharedPreferences.getString(
        SharedPrefEnum.LANGUAGE.getValue(),
        "tr"
    )

    fun updateToolTip(gosterildiMi: Boolean) {
        sharedPreferences.edit()
            .putBoolean(
                SharedPrefEnum.TOOLTIP.getValue(),
                gosterildiMi
            )
            .apply()
    }

    fun updateSiseValue(siseTuru: Int) {
        sharedPreferences.edit()
            .putInt(
                SharedPrefEnum.SISE_TURU.getValue(),
                siseTuru
            )
            .apply()
    }


    fun updateDogrulukSize(
        dogrulukSize: Int
    ) {
        sharedPreferences.edit()
            .putInt(SharedPrefEnum.DB_DOGRULUK_SIZE.getValue(), dogrulukSize)
            .apply()
    }

    fun updateDogrulukEklenenSize(
        dogrulukEklenenSize: Int
    ) {
        sharedPreferences.edit()
            .putInt(SharedPrefEnum.DB_DOGRULUK_EKLENEN_SIZE.getValue(), dogrulukEklenenSize)
            .apply()
    }

    fun updateDogrulukEklenenLastValue(
        dogrulukEklenenSize: Int
    ) {
        sharedPreferences.edit()
            .putInt(SharedPrefEnum.DB_DOGRULUK_EKLENEN_LAST_VALUE.getValue(), dogrulukEklenenSize)
            .apply()
    }

    fun updateCesaretSize(
        cesaretSize: Int
    ) {
        sharedPreferences.edit()
            .putInt(SharedPrefEnum.DB_CESARET_SIZE.getValue(), cesaretSize)
            .apply()
    }

    fun updateCesaretEklenenSize(
        cesaretEklenenSize: Int
    ) {
        sharedPreferences.edit()
            .putInt(SharedPrefEnum.DB_CESARET_EKLENEN_SIZE.getValue(), cesaretEklenenSize)
            .apply()
    }

    fun updateCesaretEklenenLastValue(
        cesaretEklenenSize: Int
    ) {
        sharedPreferences.edit()
            .putInt(SharedPrefEnum.DB_CESARET_EKLENEN_LAST_VALUE.getValue(), cesaretEklenenSize)
            .apply()
    }


    fun updateLastValue(
        dogrulukLastValue: Int,
        cesaretLastValue: Int
    ) {
        sharedPreferences.edit()
            .putInt(
                SharedPrefEnum.DB_DOGRULUK_LAST_VALUE.getValue(),
                dogrulukLastValue
            )
            .putInt(
                SharedPrefEnum.DB_CESARET_LAST_VALUE.getValue(),
                cesaretLastValue
            )
            .apply()
    }

    fun updateSoruPaketi(
        toplamSoruPaketi: String,
        guncellenenSoruPaketi: String,
        dogrulugaMiEklendi: Boolean
    ) {
        if (dogrulugaMiEklendi) {
            sharedPreferences.edit()
                .putString(SharedPrefEnum.TOPLAM_SORU_PAKETI.getValue(), toplamSoruPaketi)
                .putString(SharedPrefEnum.DOGRULUK_SORU_PAKETI.getValue(), guncellenenSoruPaketi)
                .apply()
        } else {
            sharedPreferences.edit()
                .putString(SharedPrefEnum.TOPLAM_SORU_PAKETI.getValue(), toplamSoruPaketi)
                .putString(SharedPrefEnum.CESARET_SORU_PAKETI.getValue(), guncellenenSoruPaketi)
                .apply()
        }
    }

    fun updateLanguage(language: String) {
        sharedPreferences.edit()
            .putString(SharedPrefEnum.LANGUAGE.getValue(), language)
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
                SharedPrefEnum.DB_CREATED.getValue(),
                isCreated
            )
            .putInt(
                SharedPrefEnum.DB_DOGRULUK_SIZE.getValue(),
                dogrulukSize
            )
            .putInt(
                SharedPrefEnum.DB_CESARET_SIZE.getValue(),
                cesaretSize
            )
            .putInt(
                SharedPrefEnum.DB_DOGRULUK_EKLENEN_SIZE.getValue(),
                1
            )
            .putInt(
                SharedPrefEnum.DB_CESARET_EKLENEN_SIZE.getValue(),
                1
            )
            .putInt(
                SharedPrefEnum.DB_CESARET_LAST_VALUE.getValue(),
                1
            )
            .putInt(
                SharedPrefEnum.DB_DOGRULUK_LAST_VALUE.getValue(),
                1
            )
            .putInt(
                SharedPrefEnum.DB_CESARET_EKLENEN_LAST_VALUE.getValue(),
                0
            )
            .putInt(
                SharedPrefEnum.DB_DOGRULUK_EKLENEN_LAST_VALUE.getValue(),
                0
            )
            .putInt(
                SharedPrefEnum.SISE_TURU.getValue(),
                siseTuru
            )
            .putString(
                SharedPrefEnum.TOPLAM_SORU_PAKETI.getValue(),
                "0"
            )
            .putString(
                SharedPrefEnum.DOGRULUK_SORU_PAKETI.getValue(),
                "0"
            )
            .putString(
                SharedPrefEnum.CESARET_SORU_PAKETI.getValue(),
                "0"
            )
            .putBoolean(
                SharedPrefEnum.TOOLTIP.getValue(),
                false
            )
            .putString(
                SharedPrefEnum.LANGUAGE.getValue(),
                "tr"
            )
            .apply()
    }

    fun clearSharedPref() {
        sharedPreferences.edit()
            .clear()
            .apply()
    }
}