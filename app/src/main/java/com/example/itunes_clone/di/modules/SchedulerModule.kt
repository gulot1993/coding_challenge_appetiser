package com.example.itunes_clone.di.modules

import com.example.itunes_clone.utils.schedulers.BaseScheduler
import com.example.itunes_clone.utils.schedulers.SchedulerProvider
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class SchedulerModule {
    @Singleton
    @Binds
    abstract fun providesSchedulers(scheduler: SchedulerProvider): BaseScheduler
}