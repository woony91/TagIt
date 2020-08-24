package com.example.tagit.data.remote

import com.example.tagit.data.model.PexelResponse
import com.example.tagit.data.model.Photo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PexelService {

    @GET("pictures")
    suspend fun getPictures(@Query("query") query: String): Response<PexelResponse>

    @GET("picture/{id}")
    suspend fun getPicture(@Path("id") id: Int): Response<Photo>
}