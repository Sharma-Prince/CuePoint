package com.adishakti.cuepoint.presentation.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.adishakti.cuepoint.presentation.ui.navigation.HOME_ROUTE
import com.adishakti.cuepoint.presentation.ui.navigation.homeScreen
import com.adishakti.cuepoint.presentation.ui.navigation.profileScreen
import com.adishakti.cuepoint.presentation.ui.navigation.tournamentScreen

@Composable
fun CueNavHost(
    appState: AppState,
    modifier: Modifier = Modifier,
    startDestination : String = HOME_ROUTE,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ){
        homeScreen()
        profileScreen()
        tournamentScreen()
    }
}