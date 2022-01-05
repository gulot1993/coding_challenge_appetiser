package com.example.itunes_clone.data.source

import com.example.itunes_clone.domain.Music
import io.reactivex.Completable
import io.reactivex.Single

interface MusicRepository {
    /**
     * get musics from remote source
     * then save into db
     * */
    fun getMusicsFromApiAndSaveToDb(): Single<List<Music>>

    /**
     * get musics from db
     * */
    fun getMusicsFromDb(): Single<List<Music>>

    fun saveMusicsToDb(music: List<Music>): Single<List<Long>>
}