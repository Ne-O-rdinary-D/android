package com.hiearth.fullquiz.core.network.retrofit

import com.hiearth.fullquiz.core.network.RankApi
import com.hiearth.fullquiz.core.network.datasource.RankDataSource
import com.hiearth.fullquiz.core.network.model.ApiResponse
import com.hiearth.fullquiz.core.network.model.response.RankResponse
import com.hiearth.fullquiz.core.network.util.runRemote
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitRankDataSource @Inject constructor(
    private val rankApi: RankApi
) : RankDataSource {
    override suspend fun getRankData(nickname:String): ApiResponse<RankResponse> = runRemote {
        rankApi.getRankData(nickname)
    }
}