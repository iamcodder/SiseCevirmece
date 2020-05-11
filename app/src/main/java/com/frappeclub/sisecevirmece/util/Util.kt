package com.frappeclub.sisecevirmece.util

import android.content.Context
import android.content.Intent
import android.util.Log
import com.frappeclub.sisecevirmece.enums.ImageDegree
import com.frappeclub.sisecevirmece.enums.Veri


/**     Code with ❤
╔════════════════════════════╗
║  Created by Süleyman SEZER ║
╠════════════════════════════╣
║ me.iamcodder@gmail.com     ║
╠════════════════════════════╣
║     09/03/2020 - 21:46     ║
╚════════════════════════════╝
 */

fun <ClassTipi> Context.extSayfaGecisi(
    gidilecekClass: Class<ClassTipi>,
    veri: Boolean = false
) {
    if (!veri) startActivity(Intent(this, gidilecekClass))
    else {
        val intent = Intent(this, gidilecekClass)
        intent.putExtra(Veri.DOGRULUK_CESARET.name, veri)
        this.startActivity(intent)
    }

}

infix fun String.extLogMessage(message: String) {
    Log.d(this, message)
}

fun Float.extGetRandomNumber(): Float {
    val randomNumber: IntRange = when (this.toInt()) {
        in ImageDegree.SIFIR.deger..ImageDegree.BIN.deger -> ImageDegree.BIN.deger..ImageDegree.IKIBIN.deger
        in ImageDegree.BIN.deger..ImageDegree.IKIBIN.deger -> ImageDegree.IKIBIN.deger..ImageDegree.UCBIN.deger
        in ImageDegree.IKIBIN.deger..ImageDegree.UCBIN.deger -> ImageDegree.UCBIN.deger..ImageDegree.DORTBIN.deger
        in ImageDegree.UCBIN.deger..ImageDegree.DORTBIN.deger -> ImageDegree.DORTBIN.deger..ImageDegree.BESBIN.deger
        in ImageDegree.DORTBIN.deger..ImageDegree.BESBIN.deger -> ImageDegree.BESBIN.deger..ImageDegree.ALTIBIN.deger
        in ImageDegree.BESBIN.deger..ImageDegree.ALTIBIN.deger -> ImageDegree.ALTIBIN.deger..ImageDegree.YEDIBIN.deger
        in ImageDegree.ALTIBIN.deger..ImageDegree.YEDIBIN.deger -> ImageDegree.YEDIBIN.deger..ImageDegree.SEKIZBIN.deger
        in ImageDegree.YEDIBIN.deger..ImageDegree.SEKIZBIN.deger -> ImageDegree.SEKIZBIN.deger..ImageDegree.DOKUZBIN.deger
        in ImageDegree.SEKIZBIN.deger..ImageDegree.DOKUZBIN.deger -> ImageDegree.DOKUZBIN.deger..ImageDegree.ONBIN.deger
        in ImageDegree.DOKUZBIN.deger..ImageDegree.ONBIN.deger -> ImageDegree.SIFIR.deger..ImageDegree.BIN.deger
        else -> ImageDegree.SIFIR.deger..ImageDegree.ONBIN.deger
    }
    return (randomNumber.random()).toFloat()
}
