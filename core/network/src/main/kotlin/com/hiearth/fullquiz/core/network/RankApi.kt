package com.hiearth.fullquiz.core.network

import com.hiearth.fullquiz.core.network.model.response.RankResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RankApi {
    @GET("/api/ranking/rank")
    suspend fun getRankData(
        @Query("nickname") nickname: String
    ):Response<RankResponse>
}