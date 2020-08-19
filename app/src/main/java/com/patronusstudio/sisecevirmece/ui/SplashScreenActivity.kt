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
import com.patronusstudio.sisecevirmece.abstracts.CesaretEklendiDatabase
import com.patronusstudio.sisecevirmece.abstracts.DogrulukDatabase
import com.patronusstudio.sisecevirmece.abstracts.DogrulukEklendiDatabase
import com.patronusstudio.sisecevirmece.network.FirebaseDb
import com.patronusstudio.sisecevirmece.util.*
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreenActivity : AppCompatActivity() {

    val sharedVeriSaklama by lazy {
        SharedVeriSaklama(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        this extStatusBarColor "#00000000"

        val isWrited = sharedVeriSaklama.isSharedPrefCreated()
        if (!isWrited) isntWritedShared()
        langControl()

        oyunIslemleri()

        val internetConnection = isInternetConnection(this)
        if (internetConnection) writeDb()
        startAnim()
    }

    private fun isntWritedShared() {
        val soruEkleme = SoruEkleme(this)
        val cesaretDatabase = CesaretDatabase.getDatabaseManager(this)
        cesaretDatabase.cesaretDao().insertAll(soruEkleme.cesaretListesiEkleme())

        val dogrulukDatabase = DogrulukDatabase.getDatabaseManager(this)
        dogrulukDatabase.dogrulukDao().insertAll(soruEkleme.dogrulukListesiEkleme())

        sharedVeriSaklama.putValueForFirstStarted(
            true,
            soruEkleme.dogrulukListSize,
            soruEkleme.cesaretListSize,
            0
        )
    }

    private fun oyunIslemleri() {
        OyunIslemleri.cesaretSize = sharedVeriSaklama.getCesaretListValue()
        OyunIslemleri.dogrulukSize = sharedVeriSaklama.getDogrulukListValue()
        OyunIslemleri.dogrulukEklenenLastValue = sharedVeriSaklama.getDogrulukEklenenLastValue()
        OyunIslemleri.cesaretEklenenLastValue = sharedVeriSaklama.getCesaretEklenenLastValue()

        OyunIslemleri.cesaretLastValue = sharedVeriSaklama.getCesaretSize()
        OyunIslemleri.dogrulukLastValue = sharedVeriSaklama.getDogrulukSize()
        OyunIslemleri.cesaretEklenenSize = sharedVeriSaklama.getCesaretEklenenSize()
        OyunIslemleri.dogrulukEklenenSize = sharedVeriSaklama.getDogrulukEklenenSize()

        OyunIslemleri.siseTuru = sharedVeriSaklama.getSiseTuru()

        OyunIslemleri.toplamSoruPaketi = sharedVeriSaklama.getToplamSoruPaketi() ?: "0"
        OyunIslemleri.dogrulukSoruPaketi = sharedVeriSaklama.getDogrulukSoruPaketi() ?: "0"
        OyunIslemleri.cesaretSoruPaketi = sharedVeriSaklama.getCesaretSoruPaketi() ?: "0"

    }

    private fun langControl() {
        val deviceLang = if (isLanguageTurkish()) "tr" else "en"
        val getLocatedLang = sharedVeriSaklama.getLanguage()

        if (!getLocatedLang.equals(deviceLang)) {
            sharedVeriSaklama.clearSharedPref()
            val cesaretDatabase = CesaretDatabase.getDatabaseManager(this)
            cesaretDatabase.cesaretDao().deleteAllModel()
            val dogrulukDatabase = DogrulukDatabase.getDatabaseManager(this)
            dogrulukDatabase.dogrulukDao().deleteAllModel()
            isntWritedShared()

            sharedVeriSaklama.updateLanguage(deviceLang)
        }
    }

    private fun writeDb() {
        val cesaretEklendiDatabase = CesaretEklendiDatabase.getDatabaseManager(this)
        val dogrulukEklendiDatabase = DogrulukEklendiDatabase.getDatabaseManager(this)

        val firebaseDb = FirebaseDb {
            if (!it) startAnim()
        }
        val dogrulugaEklenenSoruBoyutu =
            dogrulukEklendiDatabase.dogrulukEklenenDao().getAllModel().size
        val cesareteEklenenSoruBoyutu =
            cesaretEklendiDatabase.cesareEklenentDao().getAllModel().size

        if (dogrulugaEklenenSoruBoyutu > 0) {
            for (i in OyunIslemleri.dogrulukEklenenLastValue..OyunIslemleri.dogrulukEklenenSize) {
                val model = dogrulukEklendiDatabase.dogrulukEklenenDao().getModel(i)
                model?.soru?.let {
                    firebaseDb.addSoru(true, it)
                }
            }

            dogrulukEklendiDatabase.dogrulukEklenenDao().deleteAllModel()
            sharedVeriSaklama.updateCesaretEklenenLastValue(OyunIslemleri.dogrulukEklenenSize)
        }

        if (cesareteEklenenSoruBoyutu > 0) {
            for (i in OyunIslemleri.cesaretEklenenLastValue..OyunIslemleri.cesaretEklenenSize) {
                val model = cesaretEklendiDatabase.cesareEklenentDao().getModel(i)
                model?.soru?.let {
                    firebaseDb.addSoru(false, it)
                }
            }
            cesaretEklendiDatabase.cesareEklenentDao().deleteAllModel()
            sharedVeriSaklama.updateCesaretEklenenLastValue(OyunIslemleri.cesaretEklenenSize)
        }


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

