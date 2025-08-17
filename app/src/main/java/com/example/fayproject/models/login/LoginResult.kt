package com.example.fayproject.models.login

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResult(
    @SerialName("token")
    val token: String,
    @SerialName("error")
    val error: FayError? = null
)

@Serializable
data class FayError(
    @SerialName("message")
    val message: String?
)
