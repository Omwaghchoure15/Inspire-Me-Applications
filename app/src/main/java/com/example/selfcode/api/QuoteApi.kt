package com.example.selfcode.api

import com.example.selfcode.model.ZenQuote
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface QuoteApi {
    @Headers("X-Api-Key: YOUR_API_KEY_HERE")

    @GET("api/random")

    suspend fun getRandomQuote(
        @Query("category") category: String = "life"): List<ZenQuote>
}