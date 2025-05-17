package com.hiearth.fullquiz.core.network.model.response

import kotlinx.serialization.Serializable

@Serializable
data class NickNameResponse(
    val status: Int,
    val data: Boolean
)
