package com.patronusstudio.sisecevirmece.network

import com.google.firebase.database.FirebaseDatabase
import com.patronusstudio.sisecevirmece.enums.FirebasePathEnum
import com.patronusstudio.sisecevirmece.model.FeedbackModel
import com.patronusstudio.sisecevirmece.util.getRandomUUID


class FirebaseDb(
    val firebaseCallBack: (Boolean) -> Unit
) {
    private var mDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()

    fun addFeedback(model: FeedbackModel) {
        val databaseReference = mDatabase.getReference(FirebasePathEnum.FEEDBACK.getPathName())
        databaseReference.child("" + getRandomUUID()).setValue(model)
            .addOnSuccessListener {
                firebaseCallBack(true)
            }
            .addOnFailureListener {
                firebaseCallBack(false)
            }
    }

}