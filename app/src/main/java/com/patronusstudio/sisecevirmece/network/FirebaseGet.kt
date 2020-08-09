package com.patronusstudio.sisecevirmece.network

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.patronusstudio.sisecevirmece.enums.FirebasePathEnum
import com.patronusstudio.sisecevirmece.model.SoruPaketi
import com.patronusstudio.sisecevirmece.util.extLogMessage

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
                        "Sülo".extLogMessage("t" + soruPaketi.ToplamSoruPaketi)
                        "Sülo".extLogMessage("d" + soruPaketi.DogrulukSoruPaketi)
                        "Sülo".extLogMessage("c" + soruPaketi.CesaretSoruPaketi)
                    }
                }
            })
    }

    fun getSorular(pathId: String, dogrulukMu: Boolean) {
        //todo pathteki soru listesi dönecek
        val pathName = if (dogrulukMu) FirebasePathEnum.DOGRULUK.getPathName()
        else FirebasePathEnum.CESARET.getPathName()

        mDatabase.getReference(FirebasePathEnum.SORULAR.getPathName())
            .child(pathName).child(pathId)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                }

                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = mutableListOf<String>()
                    snapshot.children.forEach {
                        list.add("" + it.value)
                    }
                    soruListesiniDondur(list, dogrulukMu)
                }

            })

    }

}