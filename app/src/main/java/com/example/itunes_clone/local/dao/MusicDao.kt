package com.example.itunes_clone.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.itunes_clone.domain.Music
import com.example.itunes_clone.local.models.MusicEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
abstract class MusicDao {
    @Query("SELECT * FROM music")
    abstract fun getMusics(): Single<List<MusicEntity>>

    @Insert
    abstract fun insertMusic(music: MusicEntity): Single<Long>

    @Insert
    abstract fun insertMusics(musics: List<MusicEntity>): Single<List<Long>>
}