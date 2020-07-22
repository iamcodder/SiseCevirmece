package com.patronusstudio.sisecevirmece.enums

enum class IntentResultKeyEnum {
    REQUEST_CODE {
        override fun getResultKey(): Int = 42
    },
    SUCCES {
        override fun getResultKey() = 1
    },
    FAILURE {
        override fun getResultKey(): Int = 0
    };

    abstract fun getResultKey(): Int
}