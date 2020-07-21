package com.patronusstudio.sisecevirmece.binding

import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import com.patronusstudio.sisecevirmece.enums.ImageDegreeEnum
import com.patronusstudio.sisecevirmece.util.CustomTimer
import com.patronusstudio.sisecevirmece.util.extGetRandomNumber

class SiseDondurmeOnClickBinding {

    private var donduMu = false
    private var sonKonum: Float = 0f
    private var randomNumber: Float = 0f

    private lateinit var image: ImageView
    private lateinit var customTimer: CustomTimer

    fun tiklandi(
        view: View,
        customTimer: CustomTimer
    ) {
        this.customTimer = customTimer
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
                    this.duration = ImageDegreeEnum.BESBIN.deger.toLong()
                    this.fillAfter = true
                }

            animationRotate.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                    donduMu = false
                    image.isEnabled = false
                }

                override fun onAnimationEnd(animation: Animation?) {
                    donduMu = false
                    customTimer.sayacBaslat()
                }

                override fun onAnimationRepeat(animation: Animation?) {

                }
            })

            sonKonum = randomNumber
            image.startAnimation(animationRotate)

        }
    }


}