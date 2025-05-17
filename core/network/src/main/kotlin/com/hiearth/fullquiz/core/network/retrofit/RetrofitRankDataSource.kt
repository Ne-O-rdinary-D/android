package com.hiearth.fullquiz.core.network.retrofit

import com.hiearth.fullquiz.core.network.RankApi
import com.hiearth.fullquiz.core.network.datasource.RankDataSource
import com.hiearth.fullquiz.core.network.model.ApiResponse
import com.hiearth.fullquiz.core.network.model.response.rank.MyRankResponse
import com.hiearth.fullquiz.core.network.model.response.rank.RankDataResponse
import com.hiearth.fullquiz.core.network.util.runRemote
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitRankDataSource @Inject constructor(
    rankApi: RankApi
) : RankDataSource {
    override suspend fun getMyData(): ApiResponse<MyRankResponse> = runRemote {
        TODO("Not yet implemented")
    }

    override suspend fun getRankList(): ApiResponse<List<RankDataResponse>> = runRemote {
        TODO("Not yet implemented")
    }
}