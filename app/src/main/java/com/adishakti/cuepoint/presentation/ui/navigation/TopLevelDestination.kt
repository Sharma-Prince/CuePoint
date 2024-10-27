package com.adishakti.cuepoint.presentation.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.adishakti.cuepoint.presentation.ui.icon.Icons

enum class TopLevelDestination(
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector,
    val title : String
){

    TOURNAMENT(
        selectedIcon = Icons.Price,
        unselectedIcon = Icons.Price,
        title = "Tournament"
    ),
    HOME(
        selectedIcon = Icons.Home,
        unselectedIcon = Icons.Home,
        title = "Home"
    ),
    PROFILE(
        selectedIcon = Icons.Person,
        unselectedIcon = Icons.Person,
        title = "Profile"
    ),
}