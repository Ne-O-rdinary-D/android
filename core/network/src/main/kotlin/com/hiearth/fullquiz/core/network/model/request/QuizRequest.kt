package com.hiearth.fullquiz.core.network.model.request

import kotlinx.serialization.Serializable

@Serializable
data class QuizRequest(
    val isCorrect: Boolean,
    val userAnswer: String
)
