package com.adishakti.cuepoint.presentation.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.adishakti.cuepoint.presentation.ui.navigation.TopLevelDestination

@Composable
fun CueApp(
    windowSizeClass : WindowSizeClass,
    appState: AppState = rememberAppState(
        windowSizeClass
    )
){
    Scaffold(
        bottomBar = {
            Log.d("Scaffold","${appState.shouldShowBottomBar}")
            if(appState.shouldShowBottomBar){
                NiaBottomBar(
                    destination = appState.topLevelDestination,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination
                )
            }

        }
    ) { padding ->
        Row(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
                .windowInsetsPadding(
                    WindowInsets.safeContent.only(
                        WindowInsetsSides.Horizontal,
                    )
                )
        ) {
            CueNavHost(appState = appState)
        }
    }
}



@Composable
private fun NiaBottomBar(
    destination : List<TopLevelDestination>,
    onNavigateToDestination : (TopLevelDestination) -> Unit,
    currentDestination : NavDestination?,
    modifier: Modifier = Modifier,
){
    NavigationBar(
        modifier = modifier,
    ){
        destination.forEach{ destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            CueNavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    Icon(imageVector = destination.unselectedIcon, contentDescription = null)
                },
                selectedIcons = {
                    Icon(imageVector = destination.selectedIcon, contentDescription = null)
                },
                label = { Text(text = destination.title)}
            )
        }
    }
}

fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any{
        it.route?.contains(destination.name,true) ?: false
    } ?: false