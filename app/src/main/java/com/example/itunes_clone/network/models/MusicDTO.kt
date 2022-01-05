package com.example.itunes_clone.network.models

import android.os.Parcelable
import com.example.itunes_clone.domain.Music
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import timber.log.Timber

@Parcelize
data class MusicDTO(
    val trackName: String?,
    val artistName: String,
    @SerializedName("artworkUrl100")
    val imageURL: String,
    @SerializedName("trackPrice")
    val price: Double,
    @SerializedName("primaryGenreName")
    val genre: String,
    @SerializedName("longDescription")
    val description: String?
): Parcelable {
    companion object {
        fun MusicDTO.toDomain(): Music {
            return with(this) {
                Music(
                    trackName = trackName ?: "",
                    artist = artistName,
                    imageURL = imageURL,
                    price = price.toString(),
                    genre = genre,
                    description = description ?: "",
                )
            }
        }

        fun List<MusicDTO>.toListDomain(): List<Music> {
            return this.map { it.toDomain() }
        }
    }
}