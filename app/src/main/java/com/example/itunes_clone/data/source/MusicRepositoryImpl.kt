package com.example.itunes_clone.data.source

import com.example.itunes_clone.domain.Music
import com.example.itunes_clone.local.models.MusicEntity
import com.example.itunes_clone.local.source.MusicLocalSource
import com.example.itunes_clone.network.models.MusicDTO
import com.example.itunes_clone.network.source.MusicRemoteSource
import io.reactivex.Single
import timber.log.Timber
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