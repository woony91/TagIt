package com.example.tagit.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import androidx.room.Entity

@Entity(tableName = "photos")
@Parcelize
@JsonClass(generateAdapter = true)
data class Photo(
    val id: Int? = null,
    val width: Int? = null,
    val height: Int? = null,
    val url: String? = null,
    val photographer: String? = null,
    @Json(name = "photographer_url")
    val photographerUrl: String? = null,
    @Json(name = "photographer_id")
    val photographerId: Int? = null,
    val src: Src = Src(),
    val liked: Boolean? = null
) : Parcelable