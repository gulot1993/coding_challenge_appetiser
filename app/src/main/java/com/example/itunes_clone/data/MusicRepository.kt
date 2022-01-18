package com.example.itunes_clone.data

import com.example.itunes_clone.domain.Music
import com.example.itunes_clone.local.models.MusicEntity
import com.example.itunes_clone.network.models.MusicDTO
import io.reactivex.Completable
import io.reactivex.Single

interface MusicRepository {
    /**
     * get musics from remote source
     * then save into db
     * */
    fun getMusicsFromAPi(): Single<List<MusicEntity>>

    /**
     * get musics from db
     * */
    fun getMusicsFromDb(): Single<List<Music>>

    fun saveMusicsToDb(music: List<MusicEntity>): Single<List<Long>>
}