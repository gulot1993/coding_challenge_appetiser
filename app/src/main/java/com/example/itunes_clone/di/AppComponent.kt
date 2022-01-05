package com.example.itunes_clone.di

import android.app.Application
import com.example.itunes_clone.common.base.ItunesCloneApplication
import com.example.itunes_clone.data.di.RepositoryModule
import com.example.itunes_clone.di.builders.ActivityBuilder
import com.example.itunes_clone.di.modules.SchedulerModule
import com.example.itunes_clone.di.scopes.AppModule
import com.example.itunes_clone.local.di.DatabaseModule
import com.example.itunes_clone.local.di.StorageModule
import com.example.itunes_clone.network.di.ApiServiceModule
import com.example.itunes_clone.network.di.NetworkModule
import com.example.itunes_clone.network.di.RemoteSourceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            AppModule::class,
            ActivityBuilder::class,
            SchedulerModule::class,
            NetworkModule::class,
            ApiServiceModule::class,
            DatabaseModule::class,
            StorageModule::class,
            RemoteSourceModule::class,
            RepositoryModule::class
        ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
    fun inject(application: ItunesCloneApplication)
}