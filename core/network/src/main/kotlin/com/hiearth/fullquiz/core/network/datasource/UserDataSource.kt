package com.hiearth.fullquiz.core.network.datasource

import com.hiearth.fullquiz.core.network.model.ApiResponse
import com.hiearth.fullquiz.core.network.model.response.UserResponse

interface UserDataSource {
    suspend fun searchUser(userName: String): ApiResponse<UserResponse>
}