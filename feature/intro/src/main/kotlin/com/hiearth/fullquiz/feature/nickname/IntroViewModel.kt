package com.hiearth.fullquiz.feature.nickname

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiearth.fullquiz.core.data.UserRepository
import com.hiearth.fullquiz.core.local.SharedPreferenceManager
import com.hiearth.fullquiz.core.model.Interests
import com.hiearth.fullquiz.feature.nickname.model.ValidCheckType
import com.hiearth.fullquiz.feature.nickname.model.IntroUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class IntroViewModel @Inject constructor(
    userRepository: UserRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<IntroUiState> = MutableStateFlow(IntroUiState.Init)
    val uiState: StateFlow<IntroUiState> = _uiState

    fun getLoginState() = viewModelScope.launch {
        delay(500)
        if (SharedPreferenceManager.isLoggedIn()) {
            _uiState.update {
                IntroUiState.Logined
            }
        } else {
            _uiState.update {
                IntroUiState.Join()
            }
        }
    }

    fun onNicknameChanged(nickname: String) {
        if (uiState.value is IntroUiState.Join) {
            _uiState.update { prev ->
                (prev as IntroUiState.Join).copy(
                    user = prev.user.copy(name = nickname),
                    validCheckType = ValidCheckType.DUPLICATE_CHECK
                )
            }
        }
    }

    fun onInterestChanged(interests: Interests) {
        if (uiState.value is IntroUiState.Join) {
            _uiState.update { prev ->
                (prev as IntroUiState.Join).copy(
                    interests = interests
                )
            }
        }
    }


    fun onPageMove() {
        (uiState.value as? IntroUiState.Join)?.let {
            if (it.validCheckType == ValidCheckType.AVAILABLE) {
                _uiState.update { prev ->
                    (prev as IntroUiState.Join).copy(
                        isNameSet = !(prev.isNameSet)
                    )
                }
            }
        }
    }

    fun onValidCheck() {
        (uiState.value as? IntroUiState.Join)?.let {
            _uiState.update { prev ->
                (prev as IntroUiState.Join).copy(
                    validCheckType = ValidCheckType.AVAILABLE
                )
            }
        }
    }
}