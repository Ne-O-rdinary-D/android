package com.hiearth.fullquiz.core.data.mapper

import com.hiearth.fullquiz.core.model.NickNameCheck
import com.hiearth.fullquiz.core.model.Quiz
import com.hiearth.fullquiz.core.network.model.response.NickNameResponse
import com.hiearth.fullquiz.core.network.model.response.QuizResponse

internal fun NickNameResponse.toNickNameCheck(): NickNameCheck =
    NickNameCheck(
        status = data
    )