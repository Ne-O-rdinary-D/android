package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.data.mapper.toResult
import com.hiearth.fullquiz.core.data.mapper.toUser
import com.hiearth.fullquiz.core.model.User
import com.hiearth.fullquiz.core.network.datasource.UserDataSource
import com.hiearth.fullquiz.core.network.di.FakeDataSource
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    @FakeDataSource private val userDataSource: UserDataSource
) : UserRepository {
    override suspend fun searchUser(gymName: String): Result<User> {
        return userDataSource.searchUser(gymName).toResult(
            transform = { it.toUser() }
        )
    }
}