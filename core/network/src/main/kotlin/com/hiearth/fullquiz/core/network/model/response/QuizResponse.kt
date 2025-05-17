package com.hiearth.fullquiz.core.network.model.response

import kotlinx.serialization.Serializable

@Serializable
data class QuizResponse(
    val status: Int,
    val data: QuizItem
)

@Serializable
data class QuizItem(
    val quizProgressId: Int,
    val quizResponses: List<QuizResponses>
)

@Serializable
data class QuizResponses(
    val id: Int,
    val content: String,
    val firstOption: String,
    val secondOption: String,
    val answer: String,
    val isCorrect: Boolean?,
    val quizType: String,
    val index: Int,
    val explanation: String
)
