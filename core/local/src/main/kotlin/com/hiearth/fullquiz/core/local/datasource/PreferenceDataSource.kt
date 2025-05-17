package com.hiearth.fullquiz.core.local.datasource

import com.hiearth.fullquiz.core.model.Interests

interface PreferenceDataSource {

    fun setNickname(nickname: String)
    fun getNickname(): String

    fun setInterest(interest: Interests)
    fun getInterest(): Interests

    fun clearAll()

    fun setProgressIdList(progressList: List<Pair<String, Int>>)
    fun getProgressIdList(): List<Pair<String, Int>>
}