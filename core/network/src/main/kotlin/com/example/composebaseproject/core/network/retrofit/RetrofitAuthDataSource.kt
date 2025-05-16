package com.example.composebaseproject.core.network.retrofit

import com.example.composebaseproject.core.network.AuthApi
import com.example.composebaseproject.core.network.datasource.AuthDataSource
import com.example.composebaseproject.core.network.util.runRemote
import com.example.composebaseproject.core.network.model.ApiResponse
import com.example.composebaseproject.core.network.model.response.RefreshTokenResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitAuthDataSource @Inject constructor(
    val authApi: AuthApi
) : AuthDataSource {
    override suspend fun refreshToken(refreshToken: String): ApiResponse<RefreshTokenResponse> = runRemote {
        authApi.refreshToken(refreshToken)
    }
}