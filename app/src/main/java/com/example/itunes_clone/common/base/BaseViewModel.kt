package com.example.itunes_clone.common.base

import androidx.lifecycle.ViewModel
import com.example.itunes_clone.utils.schedulers.BaseScheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

open class BaseViewModel: ViewModel() {
    @Inject
    lateinit var scheduler: BaseScheduler

    val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}