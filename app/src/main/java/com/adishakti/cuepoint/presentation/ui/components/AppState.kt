package com.adishakti.cuepoint.presentation.ui.components


import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.util.trace
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.adishakti.cuepoint.presentation.ui.navigation.TopLevelDestination
import com.adishakti.cuepoint.presentation.ui.navigation.navigateToHome
import com.adishakti.cuepoint.presentation.ui.navigation.navigateToProfile
import com.adishakti.cuepoint.presentation.ui.navigation.navigateToTournament
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberAppState(
    windowSizeClass: WindowSizeClass,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
) : AppState{
    NavigationTrackingSideEffect(navController = navController)
    return remember(
        navController,
        coroutineScope
    ) {
        AppState(
            navController,
            coroutineScope,
            windowSizeClass
        )
    }
}



@Stable
class AppState(
    val navController : NavHostController,
    val coroutineScope: CoroutineScope,
    val windowSizeClass: WindowSizeClass,
){
    val currentDestination : NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val topLevelDestination : List<TopLevelDestination> = TopLevelDestination.entries

    val shouldShowBottomBar : Boolean
        @Composable
        get()  {
            TopLevelDestination.entries.forEach { destination ->
                val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
                if(selected) return true
            }
            return false
        }


    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination){
        trace("Navigation: ${topLevelDestination.name}"){
            val topLevelNavOptions = navOptions {
                popUpTo(navController.graph.findStartDestination().id){
                    saveState = true
                }

                launchSingleTop = true

                restoreState = true


            }
            when(topLevelDestination){
                TopLevelDestination.HOME -> navController.navigateToHome(
                    topLevelNavOptions
                )
                TopLevelDestination.PROFILE -> navController.navigateToProfile(
                    topLevelNavOptions
                )

                TopLevelDestination.TOURNAMENT -> navController.navigateToTournament(
                    topLevelNavOptions
                )
            }
        }
    }
}

@Composable
private fun NavigationTrackingSideEffect(navController: NavHostController){
    val listener = NavController.OnDestinationChangedListener{ _, destination, _ ->
        destination.route.toString()
    }
    navController.addOnDestinationChangedListener(listener)
}