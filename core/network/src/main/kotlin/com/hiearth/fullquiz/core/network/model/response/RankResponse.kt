package com.hiearth.fullquiz.core.network.model.response

import kotlinx.serialization.Serializable

@Serializable
data class RankResponse(
    val status: Int,
    val data: RankDataWrapper,
)

@Serializable
data class RankDataWrapper(
    val myInfo: RankUserData,
    val userRankingList: List<RankUserData>
)

@Serializable
data class RankUserData(
    val nowRank: Int,
    val nickname: String,
    val answerCnt: Int,
    val wrongCnt: Int
)
