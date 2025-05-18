package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.model.Interests
import com.hiearth.fullquiz.core.model.NickNameCheck
import com.hiearth.fullquiz.core.model.User

interface UserRepository {
    suspend fun checkNickName(nickName: String): Result<NickNameCheck>
    suspend fun setUser(nickName: String, interest: Interests)
    fun getNickname(): String
    fun getInterest(): Interests
    fun clearAll()

    suspend fun setProgressIdList(progressList: List<Pair<String, Int>>)
    fun getProgressIdList(): List<Pair<String, Int>>
}