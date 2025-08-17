package com.example.fayproject.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fayproject.models.ObservableData
import com.example.fayproject.models.login.LoginResult
import com.example.fayproject.repository.LoginRepository
import com.example.fayproject.repository.TokenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repo: LoginRepository,
    private val tokenRepository: TokenRepository
) : ViewModel() {

    private val _state = MutableStateFlow(LoginUiState())
    val state = _state.asStateFlow()

    private val _navigationEvents = MutableSharedFlow<LoginNavigationEvent>(
        replay = 1
    )
    val navigationEvents = _navigationEvents

    fun onLogin() {
        val userName = state.value.userNameTextFieldState.text
        val password = state.value.passwordTextFieldState.text
        if (userName.isBlank() || password.isBlank()) {
            updateTextFieldsWithErrorStates(userName, password)
        } else {
            viewModelScope.launch {
                repo.login(
                    userName = userName,
                    password = password
                ).map {
                    when (it) {
                        is ObservableData.Data<LoginResult> -> {
                            tokenRepository.token = it.data.token
                            _navigationEvents.emit(LoginNavigationEvent.NavigateToMainScreen)
                            state.value.copy(
                                loginButtonState = LoginButtonState.Idle
                            )
                        }

                        is ObservableData.Error -> {
                            Timber.e(it.error, "Error logging in")
                            state.value.copy(
                                userNameTextFieldState = state.value.userNameTextFieldState.copy(
                                    error = TextFieldError.GENERIC
                                ),
                                passwordTextFieldState = state.value.passwordTextFieldState.copy(
                                    error = TextFieldError.GENERIC
                                ),
                                loginButtonState = LoginButtonState.Idle
                            )
                        }

                        ObservableData.Loading -> {
                            state.value.copy(
                                userNameTextFieldState = state.value.userNameTextFieldState.copy(
                                    error = null
                                ),
                                passwordTextFieldState = state.value.passwordTextFieldState.copy(
                                    error = null
                                ),
                                loginButtonState = LoginButtonState.Loading
                            )
                        }
                    }
                }.collect(_state)
            }
        }
    }

    private fun updateTextFieldsWithErrorStates(userName: String, password: String) {
        val userNameTextFieldState = if (userName.isBlank()) {
            state.value.userNameTextFieldState.copy(
                error = TextFieldError.BLANK
            )
        } else {
            state.value.userNameTextFieldState
        }

        val passwordTextFieldState = if (password.isBlank()) {
            state.value.passwordTextFieldState.copy(
                error = TextFieldError.BLANK
            )
        } else {
            state.value.passwordTextFieldState
        }
        _state.update {
            it.copy(
                userNameTextFieldState = userNameTextFieldState,
                passwordTextFieldState = passwordTextFieldState
            )
        }
    }

    fun onUsernameChange(userName: String) {
        _state.update {
            it.copy(
                userNameTextFieldState = it.userNameTextFieldState.copy(
                    text = userName,
                    error = null
                )
            )
        }
    }

    fun onPasswordChange(password: String) {
        _state.update {
            it.copy(
                passwordTextFieldState = it.userNameTextFieldState.copy(
                    text = password,
                    error = null
                )
            )
        }
    }
}

data class LoginUiState(
    val userNameTextFieldState: TextFieldUiState = TextFieldUiState(),
    val passwordTextFieldState: TextFieldUiState = TextFieldUiState(),
    val loginButtonState: LoginButtonState = LoginButtonState.Idle
)

data class TextFieldUiState(
    val text: String = "",
    val error: TextFieldError? = null
)

sealed interface LoginButtonState {
    data object Error : LoginButtonState
    data object Loading : LoginButtonState
    data object Idle : LoginButtonState
}

enum class TextFieldError {
    BLANK,
    GENERIC
}

sealed interface LoginNavigationEvent {
    data object NavigateToMainScreen : LoginNavigationEvent
}
