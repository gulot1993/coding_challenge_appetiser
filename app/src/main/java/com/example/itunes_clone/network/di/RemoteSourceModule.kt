package com.example.itunes_clone.network.di

import com.example.itunes_clone.network.base.BaseApiService
import com.example.itunes_clone.network.MusicRemoteSource
import com.example.itunes_clone.network.MusicRemoteSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteSourceModule {
    @Singleton
    @Provides
    fun providesMusicRemoteSource(baseApiService: BaseApiService): MusicRemoteSource {
        return MusicRemoteSourceImpl(baseApiService)
    }
}