package com.example.itunes_clone.data

import com.example.itunes_clone.domain.Music
import com.example.itunes_clone.local.models.MusicEntity
import com.example.itunes_clone.local.MusicLocalSource
import com.example.itunes_clone.network.MusicRemoteSource
import io.reactivex.Single
import javax.inject.Inject

class MusicRepositoryImpl @Inject constructor(
        private val musicLocalSource: MusicLocalSource,
        private val musicRemoteSource: MusicRemoteSource
): MusicRepository {
    override fun getMusicsFromAPi(): Single<List<MusicEntity>> {
        return musicRemoteSource
            .getMusics()
    }

    override fun getMusicsFromDb(): Single<List<Music>> {
        return musicLocalSource
            .getMusics()
    }

    override fun saveMusicsToDb(music: List<MusicEntity>): Single<List<Long>> {
        return musicLocalSource
            .saveMusics(music)
    }
}