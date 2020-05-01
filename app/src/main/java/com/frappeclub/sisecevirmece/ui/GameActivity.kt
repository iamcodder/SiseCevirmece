package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.frappeclub.sisecevirmece.databinding.ActivityGameBinding
import com.frappeclub.sisecevirmece.enums.GameTimer
import com.frappeclub.sisecevirmece.enums.ImageDegree
import com.frappeclub.sisecevirmece.util.extGetRandomNumber
import com.frappeclub.sisecevirmece.util.extLogMessage
import com.frappeclub.sisecevirmece.util.extSayfaGecisi
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    private var donduMu = false
    private var sonKonum: Float = 0f
    private var randomNumber: Float = 0f

    private lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottleImg.setOnClickListener {
            dondur()
        }

    }

    override fun onResume() {
        super.onResume()
        bottleImg.isEnabled = true
    }

    private fun dondur() {

        if (!donduMu) {

            randomNumber = (randomNumber.toInt()).extGetRandomNumber().toFloat()
            (randomNumber.toString()).extLogMessage()
            val pivotY: Float = (bottleImg.height / 2).toFloat()
            val pivotX: Float = ((bottleImg.width / 2).toFloat())

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
                    binding.bottleImg.isEnabled = false
                }

                override fun onAnimationEnd(animation: Animation?) {
                    donduMu = false
                    sayacBaslat()
                }

                override fun onAnimationRepeat(animation: Animation?) {

                }
            })

            sonKonum = randomNumber
            binding.bottleImg.startAnimation(animationRotate)

        }
    }

    private fun sayacBaslat() {
        object : CountDownTimer(
            GameTimer.TWO_SECOND.getTimer(),
            GameTimer.ONE_SECOND.getTimer()
        ) {
            override fun onFinish() {
                this@GameActivity.extSayfaGecisi(DogrulukCesaretActivity::class.java)
            }

            override fun onTick(millisUntilFinished: Long) {
            }
        }.start()
    }
}


