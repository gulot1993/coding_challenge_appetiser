package com.example.itunes_clone.local.source

import com.example.itunes_clone.domain.Music
import com.example.itunes_clone.domain.Music.Companion.toEntity
import com.example.itunes_clone.domain.Music.Companion.toListEntity
import com.example.itunes_clone.local.dao.MusicDao
import com.example.itunes_clone.local.models.MusicEntity
import com.example.itunes_clone.local.models.MusicEntity.Companion.toDomain
import com.example.itunes_clone.local.models.MusicEntity.Companion.toListDomain
import com.example.itunes_clone.network.models.MusicDTO
import io.reactivex.Completable
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

class MusicLocalSourceImpl @Inject constructor(
    private val musicDao: MusicDao
): MusicLocalSource {
    override fun getMusics(): Single<List<Music>> {
        return musicDao
            .getMusics()
            .map { musicEntities ->
                musicEntities.toListDomain()
            }

    }

    override fun saveMusics(musics: List<MusicEntity>): Single<List<Long>> {
        return musicDao
            .getMusics()
            .flatMap { musicEntities ->
                if (musicEntities.isNullOrEmpty()) {
                    return@flatMap musicDao.insertMusics(musics)
                }
                val unmatchedMusics = musicEntities.filter { it.trackName !in musics.map { it.trackName } }
                return@flatMap musicDao.insertMusics(unmatchedMusics.toList())
            }
    }
}