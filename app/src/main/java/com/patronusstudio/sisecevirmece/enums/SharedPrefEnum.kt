package com.patronusstudio.sisecevirmece.enums

enum class SharedPrefEnum {

    FILE_PATH() {
        override fun getValue(): String = "com.patronusstudio.prefs"
    },
    SISE_TURU() {
        override fun getValue(): String = "siseTuru"
    },
    DB_CREATED() {
        override fun getValue(): String = "dbCreated"
    },
    DB_DOGRULUK_SIZE() {
        override fun getValue(): String = "dogrulukListSize"
    },
    DB_CESARET_SIZE() {
        override fun getValue(): String = "cesaretListSize"
    },
    DB_DOGRULUK_EKLENEN_SIZE() {
        override fun getValue(): String = "dogrulukEklenenListSize"
    },
    DB_CESARET_EKLENEN_SIZE() {
        override fun getValue(): String = "cesaretEklenenListSize"
    },
    DB_DOGRULUK_LAST_VALUE() {
        override fun getValue(): String = "dogrulukLastValue"
    },
    DB_CESARET_LAST_VALUE() {
        override fun getValue(): String = "cesaretLastValue"
    },
    DB_DOGRULUK_EKLENEN_LAST_VALUE() {
        override fun getValue(): String = "dogrulukEklenenLastValue"
    },
    DB_CESARET_EKLENEN_LAST_VALUE() {
        override fun getValue(): String = "cesaretEklenenLastValue"
    },
    TOOLTIP() {
        override fun getValue(): String = "tooltip"
    };

    abstract fun getValue(): String
}