package com.adishakti.cuepoint.presentation.ui.screen.auth

sealed class AuthIntent {
    data class SendVerification(val phoneNumber: String) : AuthIntent()
    data class VerifyCode(val code: String) : AuthIntent()
}
