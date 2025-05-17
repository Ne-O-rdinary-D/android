package com.hiearth.fullquiz.core.network.datasource

import com.hiearth.fullquiz.core.network.model.ApiResponse
import com.hiearth.fullquiz.core.network.model.response.NickNameResponse
import com.hiearth.fullquiz.core.network.model.response.UserResponse

interface UserDataSource {
    suspend fun signUp(nickName: String): ApiResponse<Unit>
    suspend fun checkNickName(nickName: String): ApiResponse<NickNameResponse>
}