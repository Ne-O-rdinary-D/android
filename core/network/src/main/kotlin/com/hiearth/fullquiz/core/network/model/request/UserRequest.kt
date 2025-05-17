package com.hiearth.fullquiz.core.network.model.request

import kotlinx.serialization.Serializable

@Serializable
data class UserRequest(
    val nickname: String
)
