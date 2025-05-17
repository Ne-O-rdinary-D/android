package com.hiearth.fullquiz.core.network.retrofit

import android.util.Log
import com.hiearth.fullquiz.core.network.QuizApi
import com.hiearth.fullquiz.core.network.datasource.QuizDataSource
import com.hiearth.fullquiz.core.network.model.ApiResponse
import com.hiearth.fullquiz.core.network.model.response.QuizResponse
import com.hiearth.fullquiz.core.network.util.runRemote
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class RetrofitQuizDataSource @Inject constructor(
    private val quizApi: QuizApi
) : QuizDataSource {
    override suspend fun getQuizList(nickName: String, category: String): ApiResponse<QuizResponse> = runRemote {
        quizApi.getQuizList(2, nickName, category)
    }
}