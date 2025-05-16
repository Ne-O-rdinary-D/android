package com.example.composebaseproject.core.network.retrofit

import com.example.composebaseproject.core.network.UserApi
import com.example.composebaseproject.core.network.datasource.UserDataSource
import com.example.composebaseproject.core.network.util.runRemote
import com.example.composebaseproject.core.network.model.ApiResponse
import com.example.composebaseproject.core.network.model.response.UserResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class RetrofitUserDataSource @Inject constructor(
    private val userApi: UserApi
) : UserDataSource {
    override suspend fun searchUser(
        gymName: String
    ): ApiResponse<UserResponse> = runRemote {
        userApi.searchUser(gymName)
    }
}