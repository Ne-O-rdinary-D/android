package com.hiearth.fullquiz.core.network

import com.hiearth.fullquiz.core.network.model.request.UserRequest
import com.hiearth.fullquiz.core.network.model.response.NickNameResponse
import com.hiearth.fullquiz.core.network.model.response.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApi {
    @POST("/api/members")
    suspend fun signUp(
        @Body params: UserRequest
    ): Response<Unit>

    @GET("/api/members")
    suspend fun checkNickName(
        @Query("nickname") nickName: String
    ): Response<NickNameResponse>

}