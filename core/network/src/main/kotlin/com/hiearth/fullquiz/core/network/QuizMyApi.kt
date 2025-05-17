package com.hiearth.fullquiz.core.network

import com.hiearth.fullquiz.core.model.QuizMyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizMyApi {
    @GET("/api/quiz/mystatus")
    suspend fun getMyStatus(
        @Query("nickname") nickname: String
    ):Response<QuizMyResponse>
}