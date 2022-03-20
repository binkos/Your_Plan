package com.vladoleg.plantracker.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vladoleg.plantracker.onboarding.ui.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    controller: NavHostController
) {
    NavHost(
        navController = controller,
        modifier = modifier,
        startDestination = AppScreen.SPLASH_SCREEN.name
    ) {
        composable(route = AppScreen.SPLASH_SCREEN.name) {
            SplashScreen()
        }
        composable(route = AppScreen.MAIN_SCREEN.name) {

        }
    }
}

enum class AppScreen {
    SPLASH_SCREEN,
    MAIN_SCREEN
}