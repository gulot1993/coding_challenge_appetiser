package com.example.itunes_clone.data.di

import com.example.itunes_clone.data.source.MusicRepository
import com.example.itunes_clone.data.source.MusicRepositoryImpl
import com.example.itunes_clone.local.source.MusicLocalSource
import com.example.itunes_clone.network.source.MusicRemoteSource
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