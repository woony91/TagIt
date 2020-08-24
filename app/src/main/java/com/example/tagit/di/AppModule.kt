package com.example.tagit.di

import android.content.Context
import com.example.tagit.data.local.AppDataBase
import com.example.tagit.data.local.PexelDao
import com.example.tagit.data.remote.PexelRemoteDataSource
import com.example.tagit.data.remote.PexelService
import com.example.tagit.data.repo.PexelRepository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi) : Retrofit = Retrofit.Builder()
        .baseUrl("https://api.pexels.com/v1/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    fun providePexelService(retrofit: Retrofit): PexelService = retrofit.create(PexelService::class.java)

    @Singleton
    @Provides
    fun providePexelRemoteDataSource(pexelService: PexelService) = PexelRemoteDataSource(pexelService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDataBase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideDao(db: AppDataBase) = db.pexelDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: PexelRemoteDataSource,
                          localDataSource: PexelDao
    ) =
        PexelRepository(remoteDataSource, localDataSource)
}