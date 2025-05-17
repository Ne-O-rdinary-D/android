package com.hiearth.fullquiz.core.network.retrofit

import com.hiearth.fullquiz.core.network.datasource.UserDataSource
import com.hiearth.fullquiz.core.network.model.ApiResponse
import com.hiearth.fullquiz.core.network.model.response.UserResponse
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class FakeUserDataSource @Inject constructor(

) : UserDataSource {
    override suspend fun searchUser(userName: String): ApiResponse<UserResponse> {
        delay(5000)
        return ApiResponse.Failure.HttpError(404, "Not Found", "")
    }
}