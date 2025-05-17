package com.hiearth.fullquiz.core.network

import com.hiearth.fullquiz.core.network.model.response.QuizResponse
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface QuizApi {

    @POST("/api/members/{memberId}/quizzes")
    suspend fun getQuizList(
        @Path("memberId") memberId: Int,
        @Query("nickname") nickname: String,
        @Query("category") category: String
    ): Response<QuizResponse>
}