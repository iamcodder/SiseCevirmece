package com.patronusstudio.sisecevirmece.enums

enum class IntentKeyEnum {
    FEEDBACKMODEL {
        override fun getModelName(): String = "FeedBackModel"
    };


    abstract fun getModelName(): String
}