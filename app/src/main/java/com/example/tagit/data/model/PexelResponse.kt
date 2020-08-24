package com.example.tagit.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class PexelResponse(
    @Json(name = "total_results")
    val totalResults: Int? = null,
    val page: Int? = null,
    @Json(name = "per_page")
    val perPage: Int? = null,
    val photos: List<Photo>? = null,
    @Json(name = "next_page")
    val nextPage: String? = null
) : Parcelable