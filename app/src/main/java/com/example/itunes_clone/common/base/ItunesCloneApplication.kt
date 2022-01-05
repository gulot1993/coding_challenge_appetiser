package com.example.itunes_clone.common.base

import android.app.Activity
import android.app.Application
import com.example.itunes_clone.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject

class ItunesCloneApplication: Application(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        AppInjector.init(app = this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}