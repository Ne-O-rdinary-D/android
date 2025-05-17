package com.hiearth.fullquiz.core.network

import com.hiearth.fullquiz.core.network.model.response.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    // example
    @GET("/api/user/search/all")
    suspend fun searchUser(
        @Query("userName") userName: String
    ): Response<UserResponse>

}