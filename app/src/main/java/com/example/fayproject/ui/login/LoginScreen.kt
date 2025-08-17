@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.example.fayproject.ui.login

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.fayproject.R
import com.example.fayproject.navigation.AppointmentsRoute
import com.example.fayproject.navigation.LoginScreenRoute

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    val loginViewModel: LoginViewModel = hiltViewModel()
    val state by loginViewModel.state.collectAsStateWithLifecycle()

    // TODO: Maybe a more lifecycle away effect might be better here
    LaunchedEffect(Unit) {
        loginViewModel.navigationEvents.collect {
            when (it) {
                LoginNavigationEvent.NavigateToMainScreen -> {
                    navController.navigate(AppointmentsRoute) {
                        popUpTo(LoginScreenRoute) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            }
        }
    }

    LoginScreenUi(
        modifier = modifier,
        state = state,
        onUsernameChange = loginViewModel::onUsernameChange,
        onPasswordChange = loginViewModel::onPasswordChange,
        onLoginClick = loginViewModel::onLogin,
    )
}

@Composable
private fun LoginScreenUi(
    modifier: Modifier = Modifier,
    state: LoginUiState,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit
) {
    var passwordVisible by remember { mutableStateOf(false) }

    val height = LocalWindowInfo.current.containerSize.height.toFloat()
    val width = LocalWindowInfo.current.containerSize.width.toFloat()

    Column(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.background
                    ),
                    start = Offset(width, 0f),
                    end = Offset(0f, height),
                )
            )
            .statusBarsPadding()
            .navigationBarsPadding()
            .imePadding()
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Spacer(Modifier.weight(0.3f))

        Image(
            painter = painterResource(R.drawable.fay_logo),
            contentDescription = stringResource(R.string.fay),
            alignment = Alignment.CenterStart,
            colorFilter = if (isSystemInDarkTheme()) {
                ColorFilter.tint(Color.White)
            } else {
                null
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        )
        Spacer(Modifier.size(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            FayTextField(
                textFieldUiState = state.userNameTextFieldState,
                textFieldType = TextFieldType.USERNAME,
                onValueChange = onUsernameChange,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                )
            )

            FayTextField(
                textFieldUiState = state.passwordTextFieldState,
                textFieldType = TextFieldType.PASSWORD,
                onValueChange = onPasswordChange,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(
                        onClick = { passwordVisible = !passwordVisible }
                    ) {
                        Icon(
                            imageVector = if (passwordVisible) {
                                Icons.Default.VisibilityOff
                            } else {
                                Icons.Default.Visibility
                            },
                            contentDescription = if (passwordVisible) {
                                stringResource(R.string.password_hide_button_desc)
                            } else {
                                stringResource(R.string.password_show_button_desc)
                            },
                            tint = MaterialTheme.colorScheme.secondary
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        if (state.loginButtonState != LoginButtonState.Loading) {
                            onLoginClick()
                        }
                    }
                )
            )
        }

        Spacer(Modifier.weight(1f))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp),
            onClick = onLoginClick,
            shape = RoundedCornerShape(8.dp),
            enabled = state.loginButtonState != LoginButtonState.Loading,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                disabledContainerColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            if (state.loginButtonState == LoginButtonState.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    strokeWidth = 2.dp
                )
            } else {
                Text(
                    text = stringResource(R.string.login),
                    color = MaterialTheme.colorScheme.inversePrimary,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
private fun FayTextField(
    modifier: Modifier = Modifier,
    textFieldUiState: TextFieldUiState,
    textFieldType: TextFieldType,
    onValueChange: (String) -> Unit,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    val tfColors = TextFieldDefaults.colors(
        focusedTextColor = MaterialTheme.colorScheme.secondary,
        unfocusedTextColor = MaterialTheme.colorScheme.secondary,
        cursorColor = MaterialTheme.colorScheme.primary,
        focusedContainerColor = MaterialTheme.colorScheme.scrim,
        unfocusedContainerColor = MaterialTheme.colorScheme.scrim,
        errorContainerColor = MaterialTheme.colorScheme.scrim,
        errorIndicatorColor = Color.Red
    )

    Column(
        modifier = Modifier.animateContentSize()
    ) {
        Text(
            text = stringResource(
                when (textFieldType) {
                    TextFieldType.USERNAME -> R.string.username
                    TextFieldType.PASSWORD -> R.string.password
                }
            ),
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.size(4.dp))
        OutlinedTextField(
            value = textFieldUiState.text,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = {
                Text(
                    text = stringResource(
                        when (textFieldType) {
                            TextFieldType.USERNAME -> R.string.username_hint
                            TextFieldType.PASSWORD -> R.string.password_hint
                        }
                    ),
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            isError = textFieldUiState.error != null,
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation,
            trailingIcon = trailingIcon,
            keyboardActions = keyboardActions,
            shape = RoundedCornerShape(8.dp),
            colors = tfColors
        )

        if (textFieldUiState.error != null) {
            Spacer(Modifier.size(4.dp))
            Text(
                text = stringResource(
                    when (textFieldUiState.error) {
                        TextFieldError.BLANK -> {
                            when (textFieldType) {
                                TextFieldType.USERNAME -> R.string.username_blank_error
                                TextFieldType.PASSWORD -> R.string.password_blank_error
                            }
                        }

                        TextFieldError.GENERIC -> R.string.login_generic_error
                    }
                ),
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

private enum class TextFieldType {
    USERNAME,
    PASSWORD
}
