package com.example.itunes_clone.features.splash

import com.example.itunes_clone.common.base.BaseViewModel
import com.example.itunes_clone.data.source.MusicRepository
import com.example.itunes_clone.domain.Music
import com.example.itunes_clone.local.models.MusicEntity
import com.example.itunes_clone.network.models.MusicDTO
import io.reactivex.Observable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val musicRepository: MusicRepository
): BaseViewModel() {

    private val _state by lazy { PublishSubject.create<SplashState>() }
    val state: Observable<SplashState> = _state

    fun getAndSaveMusics() {
        musicRepository
            .getMusicsFromAPi()
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.main())
            .subscribeBy(
                onSuccess = { musics ->
                    saveMusicToDb(musics)
                },
                onError = { throwable ->
                    _state.onNext(SplashState.SavingMusicError(msg = throwable.message))
                }
            )
            .addTo(disposables)
    }

    private fun saveMusicToDb(musics: List<MusicEntity>) {
        musicRepository
            .saveMusicsToDb(musics)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.main())
            .subscribeBy(
                    onSuccess = {
                        _state.onNext(SplashState.SavingMusicSuccess)
                    },
                    onError = { throwable ->
                        _state.onNext(SplashState.SavingMusicError(msg = throwable.message))
                    }
            )
            .addTo(disposables)
    }
}