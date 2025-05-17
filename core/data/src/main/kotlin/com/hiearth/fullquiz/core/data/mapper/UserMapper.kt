package com.hiearth.fullquiz.core.data.mapper

import com.hiearth.fullquiz.core.model.User
import com.hiearth.fullquiz.core.network.model.response.UserResponse

internal fun UserResponse.toUser(): User =
    User(
        id = id,
        name = name
    )