package com.patronusstudio.sisecevirmece.util

import android.os.CountDownTimer
import com.patronusstudio.sisecevirmece.enums.GameTimer

class CustomTimer(val sayacBitince: () -> Unit) {

    private var ikiSaniye = object : CountDownTimer(
        GameTimer.TWO_SECOND.getTimer(),
        GameTimer.ONE_SECOND.getTimer()
    ) {
        override fun onFinish() {
            sayacBitince()
        }

        override fun onTick(millisUntilFinished: Long) {
        }

    }

    fun sayacBaslat() {
        ikiSaniye.start()

    }

    fun sayacDurdur() {
        ikiSaniye.cancel()
    }

}