package com.frappeclub.sisecevirmece.util

import android.content.Context
import android.content.Intent
import android.util.Log
import com.rappeclub.sisecevirmece.enums.Sayi


/**     Code with ❤
╔════════════════════════════╗
║  Created by Süleyman SEZER ║
╠════════════════════════════╣
║ me.iamcodder@gmail.com     ║
╠════════════════════════════╣
║     09/03/2020 - 21:46     ║
╚════════════════════════════╝
 */

infix fun <ClassTipi> Context.extSayfaGecisi(gidilecekClass: Class<ClassTipi>) {
    startActivity(Intent(this, gidilecekClass))
}

fun String.extLogMessage() {
    Log.e("TAG: ", this)
}

fun Int.extGetRandomNumber(): Int {
    val randomNumber: IntRange = when (this) {
        in Sayi.SIFIR.deger..Sayi.BIN.deger -> Sayi.BIN.deger..Sayi.IKIBIN.deger
        in Sayi.BIN.deger..Sayi.IKIBIN.deger -> Sayi.IKIBIN.deger..Sayi.UCBIN.deger
        in Sayi.IKIBIN.deger..Sayi.UCBIN.deger -> Sayi.UCBIN.deger..Sayi.DORTBIN.deger
        in Sayi.UCBIN.deger..Sayi.DORTBIN.deger -> Sayi.DORTBIN.deger..Sayi.BESBIN.deger
        in Sayi.DORTBIN.deger..Sayi.BESBIN.deger -> Sayi.BESBIN.deger..Sayi.ALTIBIN.deger
        in Sayi.BESBIN.deger..Sayi.ALTIBIN.deger -> Sayi.ALTIBIN.deger..Sayi.YEDIBIN.deger
        in Sayi.ALTIBIN.deger..Sayi.YEDIBIN.deger -> Sayi.YEDIBIN.deger..Sayi.SEKIZBIN.deger
        in Sayi.YEDIBIN.deger..Sayi.SEKIZBIN.deger -> Sayi.SEKIZBIN.deger..Sayi.DOKUZBIN.deger
        in Sayi.SEKIZBIN.deger..Sayi.DOKUZBIN.deger -> Sayi.DOKUZBIN.deger..Sayi.ONBIN.deger
        in Sayi.DOKUZBIN.deger..Sayi.ONBIN.deger -> Sayi.SIFIR.deger..Sayi.BIN.deger
        else -> Sayi.SIFIR.deger..Sayi.ONBIN.deger
    }
    return randomNumber.random()
}
