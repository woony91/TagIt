package com.example.tagit.data.remote

import com.example.tagit.util.Resource.Companion.success
import retrofit2.Response
import timber.log.Timber
import com.example.tagit.util.Resource

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend() -> Response<T>): Response<T> {
        try {
            val response: Response<T> = call()
            if (response.isSuccessful){
                val body = response.body()
                if (body != null) return Resource.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String) : Response<T>{
        Timber.d(message)
        return Resource.error("Network call has failed for a following reason: $message")
    }
}