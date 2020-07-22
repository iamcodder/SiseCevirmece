package com.patronusstudio.sisecevirmece.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FeedbackModel(
    var email: String,
    var message: String
) : Parcelable