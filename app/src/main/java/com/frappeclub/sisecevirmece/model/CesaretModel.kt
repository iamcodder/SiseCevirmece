package com.frappeclub.sisecevirmece.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CesaretTablosu")
data class CesaretModel(
    //Db'de soru id ilk olarak 1 den başlıyor.
    @PrimaryKey(autoGenerate = true)
    val soruId: Int = 0,
    val soru: String,
    var sorulduMu: Boolean = false
)