package com.frappeclub.sisecevirmece.binding

import android.os.CountDownTimer
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import com.frappeclub.sisecevirmece.enums.GameTimer
import com.frappeclub.sisecevirmece.enums.ImageDegree
import com.frappeclub.sisecevirmece.util.extGetRandomNumber

class SiseDondurme(val sayfaGecisiBaslat: () -> Unit) {

    private var donduMu = false
    private var sonKonum: Float = 0f
    private var randomNumber: Float = 0f

    private lateinit var image: ImageView

    fun tiklandi(view: View) {
        image = view as ImageView
        dondur()
    }

    private fun dondur() {

        if (!donduMu) {

            randomNumber = randomNumber.extGetRandomNumber()
            val pivotY: Float = (image.height / 2).toFloat()
            val pivotX: Float = ((image.width / 2).toFloat())

            val animationRotate = RotateAnimation(
                sonKonum,
                randomNumber,
                pivotX,
                pivotY
            )
                .apply {
                    this.duration = ImageDegree.BESBIN.deger.toLong()
                    this.fillAfter = true
                }

            animationRotate.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                    donduMu = false
                    image.isEnabled = false
                }

                override fun onAnimationEnd(animation: Animation?) {
                    donduMu = false
                    sayacBaslat()
                }

                override fun onAnimationRepeat(animation: Animation?) {

                }
            })

            sonKonum = randomNumber
            image.startAnimation(animationRotate)

        }
    }

    private fun sayacBaslat() {
        object : CountDownTimer(
            GameTimer.TWO_SECOND.getTimer(),
            GameTimer.ONE_SECOND.getTimer()
        ) {
            override fun onFinish() {
                sayfaGecisiBaslat()
            }

            override fun onTick(millisUntilFinished: Long) {
            }
        }.start()
    }

}