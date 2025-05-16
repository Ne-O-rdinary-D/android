package com.example.composebaseproject.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val message: String,
    val code: Int
)
