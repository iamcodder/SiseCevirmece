package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import com.app.lets_go_splash.CreateAnim.createAnimation
import com.app.lets_go_splash.OnAnimationListener
import com.app.lets_go_splash.StarterAnimation
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.util.extSayfaGecisi
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        startAnim()

        //Todo : Soru ekleme yapılacak.Eğer ekliyse ekleme yapılmayacak.
        //Dosya okuma yazma işlemi.
        //val cesaretDatabase = CesaretDatabase.getDatabaseManager(this)
        //cesaretDatabase.cesaretDao().insert(CesaretModel(soru = "asdasd",sorulduMu = false))

    }

    private fun startAnim() {
        StarterAnimation(
            resList = getAnimList(),
            onAnimationListener = object : OnAnimationListener {
                override fun onRepeat() {}
                override fun onEnd() {
                    splashScreenImg.visibility = View.GONE
                    this@SplashScreenActivity.extSayfaGecisi(HomeActivity::class.java)
                    finish()
                }

                override fun onStartAnim() {
                }
            }
        ).startSequentialAnimation(view = splashScreenImg)

    }

    private fun getAnimList(): ArrayList<Animation> {
        val animList: ArrayList<Animation> = ArrayList()

        animList.add(createAnimation(applicationContext, R.anim.no_animation))
        animList.add(createAnimation(applicationContext, R.anim.rotate))
        animList.add(createAnimation(applicationContext, R.anim.zoom_out_fast))
        animList.add(createAnimation(applicationContext, R.anim.fade_in))

        return animList
    }


}

