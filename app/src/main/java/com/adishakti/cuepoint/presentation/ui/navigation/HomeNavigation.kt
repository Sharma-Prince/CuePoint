package com.adishakti.cuepoint.presentation.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.adishakti.cuepoint.presentation.ui.screen.home.HomeRoute

const val HOME_ROUTE = "home_route"

fun NavController.navigateToHome(navOptions: NavOptions) = navigate(HOME_ROUTE,navOptions)


fun NavGraphBuilder.homeScreen(
){
    composable(route = HOME_ROUTE){
        HomeRoute()
    }
}