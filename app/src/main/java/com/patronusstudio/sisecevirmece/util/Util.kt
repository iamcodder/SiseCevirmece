package com.patronusstudio.sisecevirmece.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.patronusstudio.sisecevirmece.enums.ImageDegreeEnum
import java.util.*
import java.util.regex.Pattern


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

infix fun Context.extToastMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Float.extGetRandomNumber(): Float {
    val randomNumber: IntRange = when (this.toInt()) {
        in ImageDegreeEnum.SIFIR.deger..ImageDegreeEnum.BIN.deger -> ImageDegreeEnum.DORTBIN.deger..ImageDegreeEnum.BESBIN.deger
        in ImageDegreeEnum.BIN.deger..ImageDegreeEnum.IKIBIN.deger -> ImageDegreeEnum.BESBIN.deger..ImageDegreeEnum.ALTIBIN.deger
        in ImageDegreeEnum.IKIBIN.deger..ImageDegreeEnum.UCBIN.deger -> ImageDegreeEnum.ALTIBIN.deger..ImageDegreeEnum.YEDIBIN.deger
        in ImageDegreeEnum.UCBIN.deger..ImageDegreeEnum.DORTBIN.deger -> ImageDegreeEnum.YEDIBIN.deger..ImageDegreeEnum.SEKIZBIN.deger
        in ImageDegreeEnum.DORTBIN.deger..ImageDegreeEnum.BESBIN.deger -> ImageDegreeEnum.SEKIZBIN.deger..ImageDegreeEnum.DOKUZBIN.deger
        in ImageDegreeEnum.BESBIN.deger..ImageDegreeEnum.ALTIBIN.deger -> ImageDegreeEnum.DOKUZBIN.deger..ImageDegreeEnum.ONBIN.deger
        in ImageDegreeEnum.ALTIBIN.deger..ImageDegreeEnum.YEDIBIN.deger -> ImageDegreeEnum.SIFIR.deger..ImageDegreeEnum.BIN.deger
        in ImageDegreeEnum.YEDIBIN.deger..ImageDegreeEnum.SEKIZBIN.deger -> ImageDegreeEnum.BIN.deger..ImageDegreeEnum.IKIBIN.deger
        in ImageDegreeEnum.SEKIZBIN.deger..ImageDegreeEnum.DOKUZBIN.deger -> ImageDegreeEnum.IKIBIN.deger..ImageDegreeEnum.UCBIN.deger
        in ImageDegreeEnum.DOKUZBIN.deger..ImageDegreeEnum.ONBIN.deger -> ImageDegreeEnum.UCBIN.deger..ImageDegreeEnum.DORTBIN.deger
        else -> ImageDegreeEnum.SIFIR.deger..ImageDegreeEnum.ONBIN.deger
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

fun String.isEmailValid(): Boolean {
    val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,8}$"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}

fun isInternetConnection(mContext: Context): Boolean {
    val connMgr = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo: NetworkInfo? = connMgr.activeNetworkInfo
    return networkInfo?.isConnected == true
}

fun getRandomUUID(): UUID = UUID.randomUUID()


