package com.hiearth.fullquiz.core.network.datasource

import com.hiearth.fullquiz.core.network.model.ApiResponse
import com.hiearth.fullquiz.core.network.model.response.RankResponse

interface RankDataSource {
    suspend fun getRankData(nickname:String): ApiResponse<RankResponse>

}