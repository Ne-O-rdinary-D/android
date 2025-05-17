package com.hiearth.fullquiz.core.model

data class RankData(
    val nickname: String,
    val correctProblem: Int,
    val incorrectProblem: Int,
    val rank: Int
)
