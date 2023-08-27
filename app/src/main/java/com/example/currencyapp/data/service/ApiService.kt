package com.example.currencyapp.data.service

import com.example.currencyapp.domain.base.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("symbols")
    suspend fun getSymbols(
        @Query("access_key") accessKey: String?,
    ): ApiResponse<Any>
  @GET("latest")
    suspend fun getLatest(
        @Query("access_key") accessKey: String?,
        @Query("base ") base : String?,
    ): ApiResponse<Any>

}