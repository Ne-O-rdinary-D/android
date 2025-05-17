package com.hiearth.fullquiz.core.model

data class Quiz(
    val quizId: Int,
    val quizType: QuizType,
    val answer: Answer,
    val content: String,
    val firstOption: String,
    val secondOption: String,
    val explanation: String,
    val userAnswer: Answer? = null
)

enum class QuizType {
    OX,
    AB,
}

enum class Answer(
    val label: String
) {
    O("O"), X("X"), A("A"), B("B")
}
