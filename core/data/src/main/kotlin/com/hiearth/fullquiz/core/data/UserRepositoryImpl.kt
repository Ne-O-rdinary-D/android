package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.local.datasource.PreferenceDataSource
import com.hiearth.fullquiz.core.model.Interests
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val preferenceDataSource: PreferenceDataSource,
) : UserRepository {

    override fun setNickname(nickname: String) {
        preferenceDataSource.setNickname(nickname)
    }

    override fun getNickname(): String {
        return preferenceDataSource.getNickname()
    }

    override fun setInterest(interest: Interests) {
        preferenceDataSource.setInterest(interest)
    }

    override fun getInterest(): Interests {
        return preferenceDataSource.getInterest()
    }

    override fun clearAll() {
        preferenceDataSource.clearAll()
    }
}