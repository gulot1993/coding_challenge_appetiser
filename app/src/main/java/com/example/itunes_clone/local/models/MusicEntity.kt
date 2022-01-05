package com.example.itunes_clone.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.itunes_clone.domain.Music

@Entity(tableName = MusicEntity.TABLE_NAME)
data class MusicEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val artist: String = "",
    val trackName: String = "",
    val imageURL: String = "",
    val price: Double = 0.00,
    val genre: String = "",
    val description: String = ""
) {
    companion object {
        const val TABLE_NAME = "music"

        fun MusicEntity.toDomain(): Music {
            return Music(
                    trackName = trackName,
                    imageURL = imageURL,
                    price = price.toString(),
                    genre = genre,
                    description = description,
                    artist = artist
                )
        }

        fun List<MusicEntity>.toListDomain(): List<Music> = this.map { it.toDomain() }
    }
}