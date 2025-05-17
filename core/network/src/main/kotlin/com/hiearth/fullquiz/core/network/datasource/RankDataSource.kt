package com.hiearth.fullquiz.core.network.datasource

import com.hiearth.fullquiz.core.network.model.ApiResponse
import com.hiearth.fullquiz.core.network.model.response.rank.MyRankResponse
import com.hiearth.fullquiz.core.network.model.response.rank.RankDataResponse

interface RankDataSource {
    suspend fun getMyData(): ApiResponse<MyRankResponse>

    suspend fun getRankList(): ApiResponse<List<RankDataResponse>>
}