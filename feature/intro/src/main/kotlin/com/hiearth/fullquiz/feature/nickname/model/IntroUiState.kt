package com.hiearth.fullquiz.feature.nickname.model

import com.hiearth.fullquiz.core.model.Interests
import com.hiearth.fullquiz.core.model.User

sealed class IntroUiState() {
    data object Init : IntroUiState()
    data object Logined : IntroUiState()
    data class Join(
        val nickName: String = "",
        val interests: Interests? = null,
        val validCheckType: ValidCheckType = ValidCheckType.DUPLICATE_CHECK,
        val isNameSet: Boolean = false
    ) : IntroUiState()

    data class Failure(val throwable: Throwable) : IntroUiState()
}

