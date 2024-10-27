package com.adishakti.cuepoint.presentation.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.adishakti.cuepoint.presentation.ui.screen.tournament.TournamentRoute

class TournamentNavigation {
}

const val TOURNAMENT_ROUTE = "tournament_route"

fun NavController.navigateToTournament(navOptions: NavOptions) = navigate(TOURNAMENT_ROUTE,navOptions)


fun NavGraphBuilder.tournamentScreen(
){
    composable(route = TOURNAMENT_ROUTE){
        TournamentRoute()
    }
}