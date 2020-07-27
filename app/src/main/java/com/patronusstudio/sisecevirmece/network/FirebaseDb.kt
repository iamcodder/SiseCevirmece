package com.patronusstudio.sisecevirmece.network

import com.google.firebase.database.FirebaseDatabase
import com.patronusstudio.sisecevirmece.enums.DogrulukCesaretEnum
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

    fun addSoru(isDogruluk: Boolean, soru: String) {
        val soruPathi =
            if (isDogruluk) DogrulukCesaretEnum.DOGRULUK.isim else DogrulukCesaretEnum.CESARET.isim

        val databaseReference = mDatabase.getReference(FirebasePathEnum.SORU_EKLEME.getPathName())
        databaseReference.child(soruPathi).child(("" + getRandomUUID()))
            .setValue(soru)
            .addOnSuccessListener {
                firebaseCallBack(true)
            }
            .addOnFailureListener {
                firebaseCallBack(false)
            }
    }

}