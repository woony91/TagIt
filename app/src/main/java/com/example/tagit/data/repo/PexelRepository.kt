package com.example.tagit.data.repo

import com.example.tagit.data.local.PexelDao
import com.example.tagit.data.remote.PexelRemoteDataSource
import com.example.tagit.util.performGetOperation
import javax.inject.Inject

class PexelRepository @Inject constructor(
    private val remoteDataSource: PexelRemoteDataSource,
    private val localDataSource: PexelDao
){

    fun getPicture(id: Int) = performGetOperation(
        databaseQuery = {localDataSource.getPicture(id) },
        networkCall = {remoteDataSource.getPicture(id)},
        saveCallResult = {localDataSource.insert(it)}
    )

    fun getPictures() = performGetOperation(
        databaseQuery = {localDataSource.getAllPictures() },
        networkCall = {remoteDataSource.getPictures() },
        saveCallResult = { localDataSource.insertAll(it.results)}
    )
}