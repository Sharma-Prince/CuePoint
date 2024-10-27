package com.adishakti.cuepoint.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.adishakti.cuepoint.presentation.theme.CuePointTheme
import com.adishakti.cuepoint.presentation.ui.screen.auth.LoginScreen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuePointTheme {
                LoginScreen()
            }
        }
    }

}
