package com.example.itunes_clone.local.source

import com.example.itunes_clone.domain.Music
import io.reactivex.Single

interface MusicLocalSource {
    /**
     * get musics from db then convert result to single list
     * */
    fun getMusics(): Single<List<Music>>
    /**
     * save musics into db
     * */
    fun saveMusics(musics: List<Music>): Single<List<Long>>
}