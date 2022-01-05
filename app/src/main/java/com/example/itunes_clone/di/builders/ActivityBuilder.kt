package com.example.itunes_clone.di.builders

import com.example.itunes_clone.di.scopes.ActivityScope
import com.example.itunes_clone.features.main.MainActivity
import com.example.itunes_clone.features.splash.SplashActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivityInjector(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeSplashActivityInjector(): SplashActivity
}