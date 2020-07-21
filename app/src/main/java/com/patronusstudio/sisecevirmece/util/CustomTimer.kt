package com.patronusstudio.sisecevirmece.util

import android.os.CountDownTimer
import com.patronusstudio.sisecevirmece.enums.GameTimerEnum

class CustomTimer(val sayacBitince: () -> Unit) {

    private var ikiSaniye = object : CountDownTimer(
        GameTimerEnum.TWO_SECOND.getTimer(),
        GameTimerEnum.ONE_SECOND.getTimer()
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