package com.adishakti.cuepoint.presentation.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adishakti.cuepoint.presentation.theme.CuePointTheme
import com.adishakti.cuepoint.presentation.ui.icon.Icons
import com.adishakti.cuepoint.presentation.ui.icon.ThemePreviews

@Composable
fun CueNavigationBar(
    modifier: Modifier = Modifier,
    content : @Composable RowScope.() -> Unit,
){
    NavigationBar(
        modifier = modifier,
        content = content,
        tonalElevation = 0.dp,
        contentColor = NiaNavigationDefaults.navigationContentColor(),
    )
}

@Composable
fun RowScope.CueNavigationBarItem(
    selected : Boolean,
    onClick : () -> Unit,
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit,
    selectedIcons: @Composable () -> Unit = icon,
    label : @Composable ( () -> Unit)? = null,
){
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = icon,
        modifier = modifier,
        label = label,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = NiaNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = NiaNavigationDefaults.navigationContentColor(),
            selectedTextColor = NiaNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = NiaNavigationDefaults.navigationContentColor(),
            indicatorColor = NiaNavigationDefaults.navigationIndicatorColor(),
        )
    )
}

@ThemePreviews
@Composable
fun CueNavigationPreview(){
    CuePointTheme {
        val items = listOf("Home","Profile")
        val icons = listOf(
            Icons.Home,
        )
        val selectedIcons = listOf(
            Icons.Home,
        )
        NavigationBar{
            items.forEachIndexed { index, item ->
                CueNavigationBarItem(
                    icon = {
                        Icon(imageVector = icons[0], contentDescription = item)
                    },
                    selectedIcons = {
                        Icon(imageVector = selectedIcons[0], contentDescription = item)
                    },
                    label = { Text(text = item) },
                    selected = index == 0,
                    onClick = {},
                )
            }
        }
    }

}


object NiaNavigationDefaults {
    @Composable
    fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant

    @Composable
    fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer

    @Composable
    fun navigationIndicatorColor() = MaterialTheme.colorScheme.secondaryContainer
}