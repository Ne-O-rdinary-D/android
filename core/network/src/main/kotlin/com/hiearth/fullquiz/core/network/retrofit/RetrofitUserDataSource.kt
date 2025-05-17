package com.hiearth.fullquiz.core.network.retrofit

import android.util.Log
import com.hiearth.fullquiz.core.network.UserApi
import com.hiearth.fullquiz.core.network.datasource.UserDataSource
import com.hiearth.fullquiz.core.network.model.ApiResponse
import com.hiearth.fullquiz.core.network.model.request.UserRequest
import com.hiearth.fullquiz.core.network.model.response.NickNameResponse
import com.hiearth.fullquiz.core.network.model.response.UserResponse
import com.hiearth.fullquiz.core.network.util.runRemote
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class RetrofitUserDataSource @Inject constructor(
    private val userApi: UserApi
) : UserDataSource {
    override suspend fun signUp(nickName: String): ApiResponse<Unit> = runRemote {
        userApi.signUp(UserRequest(nickName))
    }

    override suspend fun checkNickName(nickName: String): ApiResponse<NickNameResponse> =
        runRemote {
            userApi.checkNickName(nickName)
        }

}