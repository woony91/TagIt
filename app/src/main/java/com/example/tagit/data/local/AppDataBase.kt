package com.example.tagit.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tagit.data.model.Photo

@Database(entities = [Photo::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase(){
    abstract fun pexelDao(): PexelDao

    companion object {
        @Volatile private var instance: AppDataBase? = null

        fun getDatabase(context: Context) : AppDataBase =
            instance?: synchronized(this){
                instance?:buildDataBase(context).also{ instance = it}
            }

        private fun buildDataBase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDataBase::class.java, "pictures")
                .fallbackToDestructiveMigration()
                .build()
    }
}