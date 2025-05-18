package com.hiearth.fullquiz.core.network.model.response

import kotlinx.serialization.Serializable
import java.io.Serial

@Serializable
data class QuizProgressResponse(
    val status: Int,
    val data: List<QuizResponses>
)