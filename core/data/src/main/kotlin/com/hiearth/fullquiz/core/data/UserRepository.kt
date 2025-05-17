package com.hiearth.fullquiz.core.data

import com.hiearth.fullquiz.core.model.Interests
import com.hiearth.fullquiz.core.model.User

interface UserRepository {
    fun setUser(nickName: String, interest: Interests)
    fun getNickname(): String
    fun getInterest(): Interests
    fun clearAll()
}