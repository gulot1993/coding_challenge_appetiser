package com.example.itunes_clone.features.main

import com.example.itunes_clone.domain.Music

sealed class MainState {
    /**
     * state for getting music from db successfully
     * */
    data class GettingMusicSuccess(val musics: List<Music>): MainState()
    /**
     * state for getting music from db with error
     * */
    data class GettingMusicError(val msg: String?): MainState()
}