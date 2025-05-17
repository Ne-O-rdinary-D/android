package com.hiearth.fullquiz.core.network.model.response.rank

data class RankDataResponse(
    val nickname: String,
    val rank: Int,
    val correctProblem: Int
)