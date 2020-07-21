package com.patronusstudio.sisecevirmece.ui

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.databinding.ActivityFeedbackBinding
import com.patronusstudio.sisecevirmece.model.FeedbackModel
import com.patronusstudio.sisecevirmece.network.FirebaseDb
import com.patronusstudio.sisecevirmece.util.extToastMessage
import com.patronusstudio.sisecevirmece.util.isEmailValid

class FeedbackActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeedbackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_feedback)


        val firebaseCallBack = { it: Boolean ->
            val message: String = if (it) "Succes" else "Failure"
            this.extToastMessage(message)
        }

        val firebaseDb = FirebaseDb(firebaseCallBack)

        binding.activityFeedbackUpload.setOnClickListener {
            binding.activityFeedbackFeedback.onEditorAction(EditorInfo.IME_ACTION_DONE)
            binding.activityFeedbackMail.onEditorAction(EditorInfo.IME_ACTION_DONE)

            val emailAddress = binding.activityFeedbackMail.text.toString()
            val isValidEmail = emailAddress.isEmailValid()

            if (!isValidEmail) (it.context).extToastMessage("Geçersiz email adresi")
            else {
                val feedback = binding.activityFeedbackFeedback.text.toString()
                if (feedback.isNotBlank() && feedback.isNotEmpty()) {
                    val model = FeedbackModel(emailAddress, feedback)
                    firebaseDb.addFeedback(model)
                } else this.extToastMessage("Görüş/Öneri/Sorun kısmı boş olamaz")

            }

        }

    }

}