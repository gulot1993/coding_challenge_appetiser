package com.example.itunes_clone.data.di

import com.example.itunes_clone.data.MusicRepository
import com.example.itunes_clone.data.MusicRepositoryImpl
import com.example.itunes_clone.local.MusicLocalSource
import com.example.itunes_clone.network.MusicRemoteSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun providesMusicRepository(
            musicLocalSource: MusicLocalSource,
            musicRemoteSource: MusicRemoteSource
    ): MusicRepository {
        return MusicRepositoryImpl(musicLocalSource, musicRemoteSource)
    }
}