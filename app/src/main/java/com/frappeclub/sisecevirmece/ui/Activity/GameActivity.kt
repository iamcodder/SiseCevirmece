package com.frappeclub.sisecevirmece.ui.Activity

import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.util.extSayfaGecisi
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    private var donduMu = false
    private var sonKonum: Float = 0f
    private val IKI_SANIYE: Long = 2000L
    private var SANIYE: Long = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        pepsiYasatirSeni.setOnClickListener {
            dondur()
        }

    }

    override fun onResume() {
        super.onResume()
        pepsiYasatirSeni.isEnabled = true
    }

    private fun dondur() {

        if (!donduMu) {

            val randomNumber: Float = (4000..7500).random().toFloat()
            val pivotY: Float = (pepsiYasatirSeni.height / 2).toFloat()
            val pivotX: Float = ((pepsiYasatirSeni.width / 2).toFloat())

            val animationRotate = RotateAnimation(sonKonum, randomNumber, pivotX, pivotY).apply {
                this.duration = 5000
                this.fillAfter = true
            }

            animationRotate.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                    donduMu = false
                    pepsiYasatirSeni.isEnabled = false
                }

                override fun onAnimationEnd(animation: Animation?) {
                    donduMu = false
                    sayacBaslat()
                }

                override fun onAnimationRepeat(animation: Animation?) {

                }
            })

            sonKonum = randomNumber
            pepsiYasatirSeni.startAnimation(animationRotate)

        }
    }

    private fun sayacBaslat() {
        object : CountDownTimer(IKI_SANIYE, SANIYE) {
            override fun onFinish() {
                this@GameActivity extSayfaGecisi (DogrulukCesaretActivity::class.java)
            }

            override fun onTick(millisUntilFinished: Long) {
            }
        }.start()
    }
}


