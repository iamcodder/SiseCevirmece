package com.frappeclub.sisecevirmece

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.frappeclub.sisecevirmece.Activity.dogrulukCesaretSecimi
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    private var donduMu = false
    private var sonKonum: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        pepsiYasatirSeni.setOnClickListener {
            dondur()
        }
    }

    private fun dondur() {
        if (!donduMu) {

            val randomNumber: Float = (4000..7500).random().toFloat()
            val pivotX: Float = (pepsiYasatirSeni.width / 2).toFloat()
            val pivotY: Float = (pepsiYasatirSeni.pivotY / 2)

            val animationRotate = RotateAnimation(sonKonum, randomNumber, pivotX, pivotY).apply {
                this.duration = 5000
                this.fillAfter = true
            }
            animationRotate.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                    donduMu = true
                }

                override fun onAnimationEnd(animation: Animation?) {
                    donduMu = false
                    val intent = Intent(
                        this@GameActivity,
                        dogrulukCesaretSecimi::class.java
                    )
                    startActivity(intent)
                }

                override fun onAnimationRepeat(animation: Animation?) {

                }
            })

            sonKonum = randomNumber
            pepsiYasatirSeni.startAnimation(animationRotate)

        }
    }
}
