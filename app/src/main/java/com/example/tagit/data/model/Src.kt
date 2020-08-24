package com.example.tagit.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class Src(
    val original: String? = null,
    val large2x: String? = null,
    val large: String? = null,
    val medium: String? = null,
    val small: String? = null,
    val portrait: String? = null,
    val landscape: String? = null,
    val tiny: String? = null
) : Parcelable