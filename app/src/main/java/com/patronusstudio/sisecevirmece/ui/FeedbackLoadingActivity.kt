package com.patronusstudio.sisecevirmece.ui

import android.animation.Animator
import android.os.Build
import android.os.Bundle
import androidx.annotation.RawRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.databinding.ActivityFeedbackLoadingBinding
import com.patronusstudio.sisecevirmece.enums.IntentKeyEnum
import com.patronusstudio.sisecevirmece.enums.IntentResultKeyEnum
import com.patronusstudio.sisecevirmece.model.FeedbackModel
import com.patronusstudio.sisecevirmece.network.FirebaseDb
import com.patronusstudio.sisecevirmece.util.extToastMessage
import com.patronusstudio.sisecevirmece.util.isInternetConnection


class FeedbackLoadingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeedbackLoadingBinding
    private var resultCode: Int = IntentResultKeyEnum.FAILURE.getResultKey()
    private val animCountSize = 0

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_feedback_loading)

        val feedbackModel: FeedbackModel? =
            intent.getParcelableExtra(IntentKeyEnum.FEEDBACKMODEL.getModelName())
        lottieSet(R.raw.uploading)

        val firebaseResult = { isSucces: Boolean ->
            binding.lottieAnimation.repeatCount = animCountSize
            val rawRes = if (isSucces) R.raw.succes else R.raw.error
            resultCode =
                if (isSucces) IntentResultKeyEnum.SUCCES.getResultKey() else IntentResultKeyEnum.FAILURE.getResultKey()

            val message = if (isSucces) "Tebrikler iletiniz gönderildi" else "Bir hata oluştu"
            this.extToastMessage(message)

            lottieSet(rawRes)
            animationListener()
        }

        val firebaseDb = FirebaseDb(firebaseResult)
        if (isInternetConnection(this.applicationContext) && feedbackModel != null) firebaseDb.addFeedback(
            feedbackModel
        )
        else {
            this.extToastMessage("İnternet bağlantınızı kontrol edin")
            binding.lottieAnimation.repeatCount = animCountSize
            lottieSet(R.raw.error)
            animationListener()
        }

    }

    private fun lottieSet(@RawRes res: Int) {
        binding.lottieAnimation.cancelAnimation()
        binding.lottieAnimation.setAnimation(res)
        binding.lottieAnimation.playAnimation()
    }

    private fun animationListener() {
        binding.lottieAnimation.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                setResult(resultCode)
                finish()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }
        })
    }

}