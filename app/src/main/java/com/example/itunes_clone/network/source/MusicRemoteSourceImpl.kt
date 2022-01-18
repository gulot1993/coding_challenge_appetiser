package com.example.itunes_clone.network.source

import com.example.itunes_clone.domain.Music
import com.example.itunes_clone.local.models.MusicEntity
import com.example.itunes_clone.network.base.BaseApiService
import com.example.itunes_clone.network.models.MusicDTO
import com.example.itunes_clone.network.models.MusicDTO.Companion.toListDomain
import com.example.itunes_clone.network.models.MusicDTO.Companion.toListEntity
import io.reactivex.Single
import javax.inject.Inject

class MusicRemoteSourceImpl @Inject constructor(
    private val apiService: BaseApiService
): MusicRemoteSource {
    override fun getMusics(): Single<List<MusicEntity>> {
        return apiService
            .getMusics(term = "star", country = "au", media = "all")
            .map { response ->
                response.results.toListEntity()
            }
    }
}