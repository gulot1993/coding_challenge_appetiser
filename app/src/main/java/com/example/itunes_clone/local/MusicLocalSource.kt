package com.example.itunes_clone.local

import com.example.itunes_clone.domain.Music
import com.example.itunes_clone.local.models.MusicEntity
import com.example.itunes_clone.network.models.MusicDTO
import io.reactivex.Single

interface MusicLocalSource {
    /**
     * get musics from db then convert result to single list
     * */
    fun getMusics(): Single<List<Music>>
    /**
     * save musics into db
     * */
    fun saveMusics(musics: List<MusicEntity>): Single<List<Long>>
}