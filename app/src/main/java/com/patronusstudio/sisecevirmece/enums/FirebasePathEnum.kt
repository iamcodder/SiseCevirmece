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
    },
    SORULAR {
        override fun getPathName(): String = "Sorular"
    },
    SORU_PAKETI {
        override fun getPathName(): String = "SoruPaketi"
    },
    TOPLAM_SORU_PAKETI {
        override fun getPathName(): String = "ToplamSoruPaketi"
    },
    DOGRULUK_SORU_PAKETI {
        override fun getPathName(): String = "DogrulukSoruPaketi"
    },
    CESARET_SORU_PAKETI {
        override fun getPathName(): String = "CesaretSoruPaketi"

    };

    abstract fun getPathName(): String
}