package com.frappeclub.sisecevirmece.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DogrulukTablosu")
data class DogrulukModel(
    //Db'de soru id ilk olarak 1 den başlıyor.
    @PrimaryKey(autoGenerate = true)
    var soruId: Int = 0,
    val soru: String,
    var sorulduMu: Boolean = false
)