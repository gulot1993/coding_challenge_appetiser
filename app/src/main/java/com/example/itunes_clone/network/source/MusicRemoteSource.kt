package com.example.itunes_clone.network.source

import com.example.itunes_clone.domain.Music
import com.example.itunes_clone.local.models.MusicEntity
import com.example.itunes_clone.network.models.MusicDTO
import io.reactivex.Single

interface MusicRemoteSource {
    /**
     * get musics from api
     * */
    fun getMusics(): Single<List<MusicEntity>>
}