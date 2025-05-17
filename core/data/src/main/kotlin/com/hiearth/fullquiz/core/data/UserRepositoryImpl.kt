package com.hiearth.fullquiz.core.data

import android.util.Log
import com.hiearth.fullquiz.core.data.mapper.toNickNameCheck
import com.hiearth.fullquiz.core.data.mapper.toResult
import com.hiearth.fullquiz.core.local.datasource.PreferenceDataSource
import com.hiearth.fullquiz.core.model.Interests
import com.hiearth.fullquiz.core.model.NickNameCheck
import com.hiearth.fullquiz.core.network.datasource.UserDataSource
import com.hiearth.fullquiz.core.network.model.ApiResponse
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource,
    private val preferenceDataSource: PreferenceDataSource,
) : UserRepository {
    override suspend fun checkNickName(nickName: String): Result<NickNameCheck> {
        return userDataSource.checkNickName(nickName).toResult(
            transform = { it.toNickNameCheck() }
        )
    }

    override suspend fun setUser(nickName: String, interest: Interests) {
        preferenceDataSource.setNickname(nickName)
        when(val result = userDataSource.signUp(nickName)) {
            is ApiResponse.Failure.HttpError -> throw Throwable(result.message)
            is ApiResponse.Failure.NetworkError -> throw Throwable(result.throwable)
            is ApiResponse.Failure.UnknownApiError -> throw Throwable(result.throwable)
            is ApiResponse.Success -> {
                preferenceDataSource.setInterest(interest)
            }
        }
    }

    override fun getNickname(): String {
        return preferenceDataSource.getNickname()
    }

    override fun getInterest(): Interests {
        return preferenceDataSource.getInterest()
    }

    override fun clearAll() {
        preferenceDataSource.clearAll()
    }
}