package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.local.datasource.PreferenceDataSource
import com.hiearth.fullquiz.core.model.Interests
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val preferenceDataSource: PreferenceDataSource,
) : UserRepository {

    override fun setUser(nickName: String, interest: Interests) {
        preferenceDataSource.setNickname(nickName)
        preferenceDataSource.setInterest(interest)
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