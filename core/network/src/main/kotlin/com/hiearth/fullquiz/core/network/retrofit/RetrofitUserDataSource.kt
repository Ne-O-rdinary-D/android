package com.hiearth.fullquiz.core.network.retrofit

import com.hiearth.fullquiz.core.network.UserApi
import com.hiearth.fullquiz.core.network.datasource.UserDataSource
import com.hiearth.fullquiz.core.network.model.ApiResponse
import com.hiearth.fullquiz.core.network.model.response.UserResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class RetrofitUserDataSource @Inject constructor(
    private val userApi: UserApi
) : UserDataSource {
    override suspend fun searchUser(
        userName: String
    ): ApiResponse<UserResponse> = com.hiearth.fullquiz.core.network.util.runRemote {
        userApi.searchUser(userName)
    }
}