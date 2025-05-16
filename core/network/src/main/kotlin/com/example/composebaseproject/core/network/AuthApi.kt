package com.example.composebaseproject.core.network

import com.example.composebaseproject.core.network.model.response.RefreshTokenResponse
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApi {

    // example
    @POST("/api/refresh-token")
    suspend fun refreshToken(
        @Query("refreshToken") refreshToken: String
    ): Response<RefreshTokenResponse>

}