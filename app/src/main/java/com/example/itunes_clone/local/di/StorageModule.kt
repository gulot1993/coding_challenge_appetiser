package com.example.itunes_clone.local.di

import com.example.itunes_clone.local.db.AppDatabase
import com.example.itunes_clone.local.MusicLocalSource
import com.example.itunes_clone.local.MusicLocalSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun providesMusicLocalSource(database: AppDatabase): MusicLocalSource {
        return MusicLocalSourceImpl(database.musicDao())
    }
}