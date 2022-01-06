package com.example.itunes_clone.domain

import android.os.Parcelable
import com.example.itunes_clone.local.models.MusicEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class Music(
    val artist: String = "",
    val trackName: String = "",
    val imageURL: String = "",
    val price: String = "",
    val genre: String,
    val description: String = "",
    val videoPreviewUrl: String = ""
): Parcelable {
    companion object {
        fun Music.toEntity(): MusicEntity {
            return with(this) {
                MusicEntity(
                    artist = artist,
                    trackName = trackName,
                    imageURL = imageURL,
                    price = price.toDouble(),
                    genre = genre,
                    description = description,
                    previewUrl = videoPreviewUrl
                )
            }
        }

        fun List<Music>.toListEntity(): List<MusicEntity> = this.map { it.toEntity() }
    }
}