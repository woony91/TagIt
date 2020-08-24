package com.example.tagit.data.local

import android.provider.Contacts
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tagit.data.model.Photo

@Dao
interface PexelDao {

    @Query("SELECT * FROM photos")
    fun getAllPictures() : LiveData<List<Photo>>

    @Query("SELECT * FROM photos WHERE id = :id")
    fun getPicture(id: Int): LiveData<Photo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(photos: List<Photo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(photo: Photo)
}