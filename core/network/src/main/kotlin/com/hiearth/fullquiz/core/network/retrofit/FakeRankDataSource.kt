package com.hiearth.fullquiz.core.network.retrofit

import com.hiearth.fullquiz.core.network.datasource.RankDataSource
import com.hiearth.fullquiz.core.network.model.ApiResponse
import com.hiearth.fullquiz.core.network.model.response.RankResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeRankDataSource @Inject constructor(
) : RankDataSource {
    override suspend fun getRankData(nickname:String): ApiResponse<RankResponse> {
        TODO("Not yet implemented")
    }
}