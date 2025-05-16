package com.example.composebaseproject.core.data.mapper

import com.example.composebaseproject.core.model.User
import com.example.composebaseproject.core.network.model.response.UserResponse

internal fun UserResponse.toUser(): User =
    User(
        id = id,
        name = name
    )