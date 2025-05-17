package com.hiearth.fullquiz.core.network.retrofit

import com.hiearth.fullquiz.core.network.datasource.RankDataSource
import com.hiearth.fullquiz.core.network.model.ApiResponse
import com.hiearth.fullquiz.core.network.model.response.rank.MyRankResponse
import com.hiearth.fullquiz.core.network.model.response.rank.RankDataResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeRankDataSource @Inject constructor(
) : RankDataSource {
    override suspend fun getMyData(): ApiResponse<MyRankResponse> {
        return ApiResponse.Success(
            MyRankResponse(
                nickname = "fake",
                correctProblem = 5,
                incorrectProblem = 2,
                rank = 3
            )
        )
    }

    override suspend fun getRankList(): ApiResponse<List<RankDataResponse>> {
        return ApiResponse.Success(
            listOf(
                RankDataResponse("1", 1, 1),
                RankDataResponse("1", 1, 1),
                RankDataResponse("fake", 1, 1),
                RankDataResponse("1", 1, 1),
                RankDataResponse("1", 1, 1),
                RankDataResponse("1", 1, 1),
                RankDataResponse("1", 1, 1),
                RankDataResponse("1", 1, 1)
            )
        )
    }
}