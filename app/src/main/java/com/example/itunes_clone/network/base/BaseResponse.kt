package com.example.itunes_clone.network.base

import kotlinx.parcelize.RawValue

data class BaseResponse<T>(
        val resultCount: Int,
        val results: @RawValue T
)