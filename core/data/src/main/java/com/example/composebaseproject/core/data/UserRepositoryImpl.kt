package com.example.composebaseproject.core.data

import com.example.composebaseproject.core.data.mapper.toResult
import com.example.composebaseproject.core.data.mapper.toUser
import com.example.composebaseproject.core.model.User
import com.example.composebaseproject.core.network.datasource.UserDataSource
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
) : UserRepository {
    override suspend fun searchUser(gymName: String): Result<User> {
        return userDataSource.searchUser(gymName).toResult(
            transform = { it.toUser() }
        )
    }
}