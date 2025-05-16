package com.example.composebaseproject.core.network.datasource

import com.example.composebaseproject.core.network.model.ApiResponse
import com.example.composebaseproject.core.network.model.response.RefreshTokenResponse

interface AuthDataSource {
    suspend fun refreshToken(refreshToken: String): ApiResponse<RefreshTokenResponse>
}