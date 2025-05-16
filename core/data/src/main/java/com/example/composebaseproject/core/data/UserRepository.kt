package com.example.composebaseproject.core.data

import com.example.composebaseproject.core.model.User

interface UserRepository {
    suspend fun searchUser(gymName: String): Result<User>
}