package com.patronusstudio.sisecevirmece.enums

enum class FirebasePathEnum {

    FEEDBACK {
        override fun getPathName(): String = "Feedback"
    },
    SORU_EKLEME {
        override fun getPathName(): String = "SoruEkleme"
    },
    SORU {
        override fun getPathName(): String = "Soru"
    };

    abstract fun getPathName(): String
}