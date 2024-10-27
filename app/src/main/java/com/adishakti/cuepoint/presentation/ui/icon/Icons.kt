package com.adishakti.cuepoint.presentation.ui.icon

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.ui.tooling.preview.Preview

object Icons {
    val Price = Icons.Rounded.ThumbUp
    val Person = Icons.Rounded.Person
    val Home = Icons.Rounded.Home
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, name = "Light theme")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark theme")
annotation class ThemePreviews