package com.patronusstudio.sisecevirmece.enums

enum class GameTimer {
    ONE_SECOND {
        override fun getTimer(): Long = 1000L
    },
    TWO_SECOND {
        override fun getTimer(): Long = 2000L
    };

    abstract fun getTimer(): Long
}