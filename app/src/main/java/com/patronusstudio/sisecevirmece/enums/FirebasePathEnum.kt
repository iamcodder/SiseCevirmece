package com.patronusstudio.sisecevirmece.enums

enum class FirebasePathEnum {

    FEEDBACK {
        override fun getPathName(): String = "Feedback"
    },
    SORU_EKLEME {
        override fun getPathName(): String = "SoruEkleme"
    },
    CESARET {
        override fun getPathName(): String = "Cesaret"
    },
    DOGRULUK {
        override fun getPathName(): String = "Dogruluk"
    };

    abstract fun getPathName(): String
}