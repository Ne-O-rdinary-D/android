package com.example.composebaseproject.core.network.datasource

import com.example.composebaseproject.core.network.model.ApiResponse
import com.example.composebaseproject.core.network.model.response.UserResponse

interface UserDataSource {
    suspend fun searchUser(userName: String): ApiResponse<UserResponse>
}