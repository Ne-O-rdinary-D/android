package com.hiearth.fullquiz.core.data.mapper

import com.hiearth.fullquiz.core.model.RankData
import com.hiearth.fullquiz.core.network.model.response.rank.MyRankResponse
import com.hiearth.fullquiz.core.network.model.response.rank.RankDataResponse

internal fun RankDataResponse.toRankData() = RankData(
    nickname = nickname,
    correctProblem = correctProblem,
    incorrectProblem = -1,
    rank = rank
)

internal fun MyRankResponse.toRankData() = RankData(
    nickname = nickname,
    correctProblem = correctProblem,
    incorrectProblem = incorrectProblem,
    rank = rank
)