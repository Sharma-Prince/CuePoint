package com.adishakti.cuepoint.presentation.ui.screen.auth

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.adishakti.cuepoint.presentation.viewmodel.AuthViewModel

@Composable
fun LoginScreen(viewModel: AuthViewModel = hiltViewModel()) {
    val context = LocalContext.current as Activity
    val authState by viewModel.authState.collectAsState()

    when (authState) {
        is AuthState.Idle -> {
            PhoneNumberInput { phoneNumber ->
                viewModel.sendVerificationCode(phoneNumber, context)
            }
        }
        AuthState.CodeSent -> {
            VerificationCodeInput { code ->
                viewModel.verifyCode(code)
            }
        }
        is AuthState.Success -> {
            val userId = (authState as AuthState.Success).userId
            Text("Welcome, user $userId!")
        }
        is AuthState.Error -> {
            val message = (authState as AuthState.Error).message
            Text("Error: $message")
        }
    }
}

@Composable
fun PhoneNumberInput(onPhoneEntered: (String) -> Unit) {
    var phoneNumber by remember { mutableStateOf("") }
    Column {
        TextField(value = phoneNumber, onValueChange = { phoneNumber = it }, label = { Text("Phone Number") })
        Button(onClick = { onPhoneEntered(phoneNumber) }) {
            Text("Send Verification Code")
        }
    }
}

@Composable
fun VerificationCodeInput(onCodeEntered: (String) -> Unit) {
    var code by remember { mutableStateOf("") }
    Column {
        TextField(value = code, onValueChange = { code = it }, label = { Text("Verification Code") })
        Button(onClick = { onCodeEntered(code) }) {
            Text("Verify Code")
        }
    }
}
