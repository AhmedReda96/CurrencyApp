package com.example.currencyapp.domain.repository

import com.example.currencyapp.app.utils.ConstantStrings
import com.example.currencyapp.app.utils.Mapper
import com.example.currencyapp.data.service.ApiService
import com.example.currencyapp.domain.base.ApiResponse
import com.example.currencyapp.domain.model.latest.LatestRequest
import com.example.currencyapp.domain.model.symbols.SymbolRequest
import javax.inject.Inject

class CurrencyRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getSymbols(
        request: SymbolRequest,
    ): ApiResponse<Any> =
        apiService.getSymbols(request.accessKey)


    suspend fun getLatest(
        request: LatestRequest,
    ): ApiResponse<Any> {
        val response = apiService.getLatest(request.accessKey, request.base)
        return ApiResponse(
            response.success == true,
            response.timestamp!!,
            response.base.toString(),
            response.date.toString(),
            Mapper.convertRatesJsonObjectToList(response.date as String,ConstantStrings.RATES)
        )

    }
}