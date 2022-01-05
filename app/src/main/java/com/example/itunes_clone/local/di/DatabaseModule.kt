package com.example.itunes_clone.local.di

import android.app.Application
import com.example.itunes_clone.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun providesDatabase(application: Application) =
        AppDatabase.getInstance(application.applicationContext)
}