package com.patronusstudio.sisecevirmece.enums

import com.patronusstudio.sisecevirmece.R

enum class SiseSecimiEnum {
    Gazoz {
        override fun getSiseName(): String = "Gazoz"
        override fun getSiseId(): Int = 0
        override fun getSiseImage(): Int = R.drawable.beer
    },
    Kola {
        override fun getSiseName(): String = "Kola"
        override fun getSiseId(): Int = 1
        override fun getSiseImage(): Int = R.drawable.cola
    },
    Sarap {
        override fun getSiseName(): String = "Bira"
        override fun getSiseId(): Int = 2
        override fun getSiseImage(): Int = R.drawable.whisky
    },
    Bira {
        override fun getSiseName(): String = "Şarap"
        override fun getSiseId(): Int = 3
        override fun getSiseImage(): Int = R.drawable.wine
    },
    EskiSarap {
        override fun getSiseName(): String = "Eski Şarap"
        override fun getSiseId(): Int = 4
        override fun getSiseImage(): Int = R.drawable.wine2
    },
    Sampanya {
        override fun getSiseName(): String = "Şampanya"
        override fun getSiseId(): Int = 5

        override fun getSiseImage(): Int = R.drawable.champagne
    },
    Cayci {
        override fun getSiseName(): String = "Çaycı"
        override fun getSiseId(): Int = 6
        override fun getSiseImage(): Int = R.drawable.tea
    };

    abstract fun getSiseName(): String
    abstract fun getSiseId(): Int
    abstract fun getSiseImage(): Int
}