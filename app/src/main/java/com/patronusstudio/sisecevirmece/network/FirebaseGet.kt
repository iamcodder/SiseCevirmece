package com.patronusstudio.sisecevirmece.network

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.patronusstudio.sisecevirmece.enums.FirebasePathEnum
import com.patronusstudio.sisecevirmece.model.SoruPaketi

class FirebaseGet(
    val soruPaketiDondur: (SoruPaketi) -> Unit
) {

    private val mDatabase by lazy {
        FirebaseDatabase.getInstance()
    }

    fun getToplamSoru() {

        mDatabase.getReference(FirebasePathEnum.SORULAR.getPathName())
            .child(FirebasePathEnum.SORU_PAKETI.getPathName())
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                }

                override fun onDataChange(snapshot: DataSnapshot) {
                    val soruPaketi = snapshot.getValue(SoruPaketi::class.java)
                    if (soruPaketi != null) {
                        soruPaketiDondur(soruPaketi)
                    }
                }
            })
    }

    fun getSorular(pathId: String, dogrulukMu: Boolean) {
        //todo pathteki soru listesi dönecek

    }

}