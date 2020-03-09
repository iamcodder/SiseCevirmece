package com.frappeclub.sisecevirmece.util

import android.content.Context
import android.content.Intent
import android.util.Log


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

fun String.logMessage() {
    Log.e("TAG: ", this)
}