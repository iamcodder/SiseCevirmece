package com.frappeclub.sisecevirmece.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "CesaretTablosu")
data class CesaretModel(
    //Db'de soru id ilk olarak 1 den başlıyor.
    @PrimaryKey(autoGenerate = true)
    var soruId: Int = 0,
    var soru: String,
    var sorulduMu: Boolean = false
) : Parcelable