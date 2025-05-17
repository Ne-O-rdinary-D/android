package com.hiearth.fullquiz.core.network.model.response.rank

data class MyRankResponse(
    val nickname: String,
    val correctProblem: Int,
    val incorrectProblem: Int,
    val rank:Int
)