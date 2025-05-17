package com.hiearth.fullquiz.core.network.model.response

import com.google.gson.annotations.SerializedName

data class RankResponse(
    @SerializedName("status")
    val status: Int,

    @SerializedName("message")
    val message: String? = null,

    @SerializedName("data")
    val data: RankDataWrapper,

    @SerializedName("errorCode")
    val errorCode: String? = null
)

data class RankDataWrapper(
    @SerializedName("myInfo")
    val myInfo: RankUserData,

    @SerializedName("userRankingList")
    val userRankingList: List<RankUserData>
)

data class RankUserData(
    @SerializedName("nowRank")
    val nowRank: Int,

    @SerializedName("nickname")
    val nickname: String,

    @SerializedName("answerCnt")
    val answerCnt: Int,

    @SerializedName("wrongCnt")
    val wrongCnt: Int
)
