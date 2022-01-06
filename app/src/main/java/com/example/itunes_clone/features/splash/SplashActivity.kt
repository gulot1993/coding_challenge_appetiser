package com.example.itunes_clone.features.splash

import android.content.Intent
import android.os.Bundle
import com.example.itunes_clone.R
import com.example.itunes_clone.common.base.BaseViewModelActivity
import com.example.itunes_clone.databinding.ActivitySplashBinding
import com.example.itunes_clone.features.main.MainActivity
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber
import kotlin.reflect.KClass

class SplashActivity: BaseViewModelActivity<SplashViewModel, ActivitySplashBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getAndSaveMusics()
        setupVMObservers()
    }
    private fun setupVMObservers() {
        viewModel
            .state
            .observeOn(scheduler.main())
            .subscribeBy(
                onNext = { state ->
                    handleState(state = state)
                },
                onError = { throwable ->
                    throwable.message?.let { message ->
                        showError(message)
                    }
                }
            )
            .addTo(disposables)
    }

    private fun handleState(state: SplashState) {
        when (state) {
            is SplashState.SavingMusicSuccess -> {
                finishActivity()
            }
            is SplashState.SavingMusicError -> {
                state.msg?.let {
                    showError(it)
                    finishActivity()
                }
            }
        }
    }

    private fun finishActivity() {
        navigateToActivity(MainActivity::class.java)
        finish()
    }
}