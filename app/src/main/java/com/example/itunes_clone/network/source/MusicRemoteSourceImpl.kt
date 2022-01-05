package com.example.itunes_clone.network.source

import com.example.itunes_clone.domain.Music
import com.example.itunes_clone.network.base.BaseApiService
import com.example.itunes_clone.network.models.MusicDTO.Companion.toListDomain
import io.reactivex.Single
import javax.inject.Inject

class MusicRemoteSourceImpl @Inject constructor(
    private val apiService: BaseApiService
): MusicRemoteSource {
    override fun getMusics(): Single<List<Music>> {
        return apiService
            .getMusics(term = "star", country = "au", media = "all")
            .map { response ->
                response.results.toListDomain()
            }
    }
}