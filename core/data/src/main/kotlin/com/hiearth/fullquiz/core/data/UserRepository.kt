package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.model.User

interface UserRepository {
    suspend fun searchUser(gymName: String): Result<User>
}