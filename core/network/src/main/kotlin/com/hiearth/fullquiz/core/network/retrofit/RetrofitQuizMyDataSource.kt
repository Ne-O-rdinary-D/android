package com.hiearth.fullquiz.core.network.retrofit

import com.hiearth.fullquiz.core.network.QuizMyApi
import com.hiearth.fullquiz.core.network.datasource.QuizMyDataSource
import com.hiearth.fullquiz.core.network.model.ApiResponse
import com.hiearth.fullquiz.core.model.QuizMyResponse
import com.hiearth.fullquiz.core.network.util.runRemote
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitQuizMyDataSource @Inject constructor(
    private val quizMyApi: QuizMyApi
):QuizMyDataSource {
    override suspend fun getMyStatus(nickname:String): ApiResponse<QuizMyResponse> = runRemote{
        quizMyApi.getMyStatus(nickname)
    }
}