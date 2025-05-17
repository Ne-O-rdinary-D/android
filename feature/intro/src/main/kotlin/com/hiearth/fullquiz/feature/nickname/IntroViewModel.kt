package com.hiearth.fullquiz.feature.nickname

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiearth.fullquiz.core.data.UserRepository
import com.hiearth.fullquiz.core.model.Interests
import com.hiearth.fullquiz.feature.nickname.model.IntroUiState
import com.hiearth.fullquiz.feature.nickname.model.ValidCheckType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntroViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<IntroUiState> = MutableStateFlow(IntroUiState.Init)
    val uiState: StateFlow<IntroUiState> = _uiState

    fun getLoginState() = viewModelScope.launch {
        delay(1500)
        if (userRepository.getNickname().isNotEmpty()) {
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
                    validCheckType = ValidCheckType.DUPLICATE_CHECK,
                    nickName = nickname,
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

    fun setUser() {
        viewModelScope.launch {
            val request = uiState.value as IntroUiState.Join
            val name = request.nickName
            if(request.nickName.isNotEmpty() && request.interests != null) {
                userRepository.setUser(name, request.interests)
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
        viewModelScope.launch {
            userRepository.checkNickName(
                (uiState.value as IntroUiState.Join).nickName
            ).onSuccess {
                if(it.status) {
                    _uiState.update { prev ->
                        (prev as IntroUiState.Join).copy(
                            validCheckType = ValidCheckType.AVAILABLE
                        )
                    }
                } else {
                    _uiState.update { prev ->
                        (prev as IntroUiState.Join).copy(
                            validCheckType = ValidCheckType.UNAVAILABLE
                        )
                    }
                }
            }.onFailure {
                _uiState.update { prev ->
                    (prev as IntroUiState.Join).copy(
                        validCheckType = ValidCheckType.UNAVAILABLE
                    )
                }
            }
        }
    }
}