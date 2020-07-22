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


class FeedbackLoadingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeedbackLoadingBinding
    private var resultCode: Int = 0

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_feedback_loading)

        val feedbackModel: FeedbackModel =
            intent.getParcelableExtra(IntentKeyEnum.FEEDBACKMODEL.getModelName())!!
        lottieSet(R.raw.uploading)

        val firebaseResult = { isSucces: Boolean ->
            val rawRes = if (isSucces) R.raw.succes else R.raw.error
            resultCode =
                if (isSucces) IntentResultKeyEnum.SUCCES.getResultKey() else IntentResultKeyEnum.FAILURE.getResultKey()

            lottieSet(rawRes)
            animationListener()
        }

        val firebaseDb = FirebaseDb(firebaseResult)
        firebaseDb.addFeedback(feedbackModel)

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