package com.patronusstudio.sisecevirmece.enums

enum class DatabaseNameEnum {

    CESARET_DB {
        override fun getDatabaseName(): String = "Cesaret.db"
    },
    DOGRULUK_DB {
        override fun getDatabaseName(): String = "Dogruluk.db"
    },
    SORU_EKLEME_CESARET_DB {
        override fun getDatabaseName(): String = "CesaretEklendi.db"
    },
    SORU_EKLEME_DOGRULUK_DB {
        override fun getDatabaseName(): String = "DogrulukEklendi.db"
    };

    abstract fun getDatabaseName(): String

}