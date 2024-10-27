package com.adishakti.cuepoint.presentation.ui.screen.auth

sealed class AuthState {
    object Idle : AuthState()
    object CodeSent : AuthState()
    data class Success(val userId: String?, val phoneNumber: String?) : AuthState()
    data class Error(val message: String) : AuthState()
}
