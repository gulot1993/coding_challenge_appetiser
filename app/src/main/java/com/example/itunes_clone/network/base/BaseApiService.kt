package com.example.itunes_clone.network.base

import com.example.itunes_clone.network.models.MusicDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BaseApiService {
    @GET("search")
    fun getMusics(
        @Query("term") term: String,
        @Query("country") country: String,
        @Query("media") media: String
    ): Single<BaseResponse<List<MusicDTO>>>
}