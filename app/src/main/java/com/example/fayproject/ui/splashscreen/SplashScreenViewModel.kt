package com.example.fayproject.ui.splashscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fayproject.repository.TokenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    tokenRepository: TokenRepository
) : ViewModel() {

    private val _navigationEvents = MutableSharedFlow<SplashNavigationEvent>(
        replay = 1
    )
    val navigationEvents = _navigationEvents

    init {
        val token = tokenRepository.token
        viewModelScope.launch {
            val splashNavigationEvent = if (!token.isNullOrBlank()) {
                SplashNavigationEvent.NavigateToMainScreen
            } else {
                SplashNavigationEvent.NavigateToLogin
            }

            _navigationEvents.emit(splashNavigationEvent)
        }
    }
}

sealed interface SplashNavigationEvent {
    data object NavigateToLogin : SplashNavigationEvent
    data object NavigateToMainScreen : SplashNavigationEvent
}
