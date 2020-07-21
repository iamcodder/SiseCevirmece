package com.patronusstudio.sisecevirmece.network

import com.google.firebase.database.FirebaseDatabase
import com.patronusstudio.sisecevirmece.model.FeedbackModel
import java.util.*


class FirebaseDb(
    val firebaseCallBack: (Boolean) -> Unit
) {
    private var mDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()

    fun addFeedback(model: FeedbackModel) {
        val uid = UUID.randomUUID()
        val databaseReference = mDatabase.getReference("feedback")
        databaseReference.child("" + uid).setValue(model)
            .addOnSuccessListener {
                firebaseCallBack(true)
            }
            .addOnFailureListener {
                firebaseCallBack(false)
            }
    }

}