package com.patronusstudio.sisecevirmece.ui

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import com.app.lets_go_splash.CreateAnim
import com.app.lets_go_splash.OnAnimationListener
import com.app.lets_go_splash.StarterAnimation
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.abstracts.CesaretDatabase
import com.patronusstudio.sisecevirmece.abstracts.DogrulukDatabase
import com.patronusstudio.sisecevirmece.util.*
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        this extStatusBarColor "#00000000"

        val sharedVeriSaklama = SharedVeriSaklama(this)
        val isWrited = sharedVeriSaklama.isSharedPrefCreated()

        if (!isWrited) {
            val soruEkleme = SoruEkleme(this)
            val cesaretDatabase = CesaretDatabase.getDatabaseManager(this)
            cesaretDatabase.cesaretDao().insertAll(soruEkleme.cesaretListesiEkleme())

            val dogrulukDatabase = DogrulukDatabase.getDatabaseManager(this)
            dogrulukDatabase.dogrulukDao().insertAll(soruEkleme.dogrulukListesiEkleme())

            sharedVeriSaklama.putValueForFirstStarted(
                true,
                soruEkleme.dogrulukListSize,
                soruEkleme.cesaretListSize,
                4
            )
        }

        OyunIslemleri.cesaretSize = sharedVeriSaklama.getCesaretListValue()
        OyunIslemleri.dogrulukSize = sharedVeriSaklama.getDogrulukListValue()

        OyunIslemleri.cesaretLastValue = sharedVeriSaklama.getCesaretLastValue()
        OyunIslemleri.dogrulukLastValue = sharedVeriSaklama.getDogrulukLastValue()

        OyunIslemleri.siseTuru = sharedVeriSaklama.getSiseTuru()

        startAnim()


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

        animList.add(CreateAnim.createAnimation(applicationContext, R.anim.no_animation))
        animList.add(CreateAnim.createAnimation(applicationContext, R.anim.rotate))
        animList.add(CreateAnim.createAnimation(applicationContext, R.anim.zoom_out_fast))
        animList.add(CreateAnim.createAnimation(applicationContext, R.anim.fade_in))

        return animList
    }


}

