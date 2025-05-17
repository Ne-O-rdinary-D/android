package com.hiearth.fullquiz.core.network.model.response

import com.hiearth.fullquiz.core.model.Answer
import com.hiearth.fullquiz.core.model.QuizType
import kotlinx.serialization.Serializable

@Serializable
data class QuizResponse(
    val quizId: Int,
    val quizType: QuizType,
    val answer: Answer,
    val content: String,
    val firstOption: String,
    val secondOption: String,
    val explanation: String
)
