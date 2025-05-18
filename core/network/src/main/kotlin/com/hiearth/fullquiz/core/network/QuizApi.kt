package com.hiearth.fullquiz.core.network

import com.hiearth.fullquiz.core.network.model.request.QuizRequest
import com.hiearth.fullquiz.core.network.model.response.QuizProgressResponse
import com.hiearth.fullquiz.core.network.model.response.QuizResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
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

    @POST("/api/members/{memberId}/quizzes/{quizId}")
    suspend fun postCurrentQuiz(
        @Path("quizId") quizId: String,
        @Query("nickname") nickname: String,
        @Body params: QuizRequest
    ): Response<Unit>

    @GET("/api/quizzes/{quizProgressId}")
    suspend fun getProgressQuiz(
        @Path("quizProgressId") quizProgressId: Long
    ): Response<QuizProgressResponse>
}