package com.patronusstudio.sisecevirmece.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.view.Window
import android.view.WindowManager
import com.patronusstudio.sisecevirmece.enums.ImageDegree


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
    birinciVeriyeErisimIsmi: String = "",
    birinciGonderilenVeri: Boolean = false
) {
    if (!birinciGonderilenVeri) startActivity(Intent(this, gidilecekClass))
    else {
        val intent = Intent(this, gidilecekClass)
        intent.putExtra(birinciVeriyeErisimIsmi, birinciGonderilenVeri)
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

infix fun Activity.extStatusBarColor(color: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        val window: Window = this.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.parseColor(color)
    }
}

