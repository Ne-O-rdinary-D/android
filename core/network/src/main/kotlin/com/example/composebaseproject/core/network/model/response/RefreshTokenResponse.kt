package com.example.composebaseproject.core.network.model.response

data class RefreshTokenResponse(
    val accessToken: String,
    val refreshToken: String
)