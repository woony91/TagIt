package com.example.tagit.data.remote

import javax.inject.Inject

class PexelRemoteDataSource @Inject constructor(
    private val pexelService: PexelService
): BaseDataSource() {
    suspend fun getPictures() = getResult { pexelService.getPictures() }
    suspend fun getPicture(id = Int) = getResult { pexelService.getPicture(id) }
}