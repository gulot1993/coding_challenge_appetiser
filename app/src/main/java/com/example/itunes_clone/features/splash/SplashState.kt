package com.example.itunes_clone.features.splash

sealed class SplashState {
    /**
    *  state when done getting and saving music
    * */
    object SavingMusicSuccess: SplashState()

    /**
     * state when error occurs
     * */
    data class SavingMusicError(val msg: String?): SplashState()
}