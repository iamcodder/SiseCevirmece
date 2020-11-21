package com.patronusstudio.sisecevirmece.firebase

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.patronusstudio.sisecevirmece.enums.FirebasePathEnum
import com.patronusstudio.sisecevirmece.model.SoruPaketi
import com.patronusstudio.sisecevirmece.util.isLanguageTurkish

class FirebaseGet(
    val soruPaketiDondur: (SoruPaketi) -> Unit,
    val soruListesiniDondur: (soruListesi: MutableList<String>, dogrulukMu: Boolean) -> Unit
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
        val pathName = if (dogrulukMu) FirebasePathEnum.DOGRULUK.getPathName()
        else FirebasePathEnum.CESARET.getPathName()

        val lang = if (isLanguageTurkish()) "tr" else "en"

        mDatabase.getReference(FirebasePathEnum.SORULAR.getPathName())
            .child(pathName).child(lang).child(pathId)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                }

                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = ArrayList<String>()
                    snapshot.children.forEach {
                        list.add("" + it.value)
                    }
                    soruListesiniDondur(list, dogrulukMu)
                }

            })

    }

}