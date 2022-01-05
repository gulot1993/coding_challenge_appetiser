package com.example.itunes_clone.network.di

import com.example.itunes_clone.network.base.BaseApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiServiceModule {
    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): BaseApiService {
        return retrofit.create(BaseApiService::class.java)
    }
}