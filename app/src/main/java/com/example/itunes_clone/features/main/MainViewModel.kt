package com.example.itunes_clone.features.main

import com.example.itunes_clone.common.base.BaseViewModel
import com.example.itunes_clone.data.source.MusicRepository
import io.reactivex.Observable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val musicRepository: MusicRepository
): BaseViewModel() {
    private val _state by lazy { PublishSubject.create<MainState>() }
    val state: Observable<MainState> = _state

    fun getMusicFromDb() {
        musicRepository
                .getMusicsFromDb()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.main())
                .subscribeBy(
                    onSuccess = { musics ->
                        _state.onNext(MainState.GettingMusicSuccess(musics = musics.sortedBy { it.trackName }))
                    },
                    onError = { throwable ->
                        _state.onNext(MainState.GettingMusicError(msg = throwable.message))
                    }
                )
                .addTo(disposables)
    }
}