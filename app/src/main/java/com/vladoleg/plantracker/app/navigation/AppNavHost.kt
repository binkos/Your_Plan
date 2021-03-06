package com.vladoleg.plantracker.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vladoleg.plantracker.main.ui.MainScreen
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
            val toMainScreen = { controller.navigate(AppScreen.MAIN_SCREEN.name) { popUpTo(0) } }
            SplashScreen(toMainScreen)
        }
        composable(route = AppScreen.MAIN_SCREEN.name) {
            MainScreen()
        }
    }
}

enum class AppScreen {
    SPLASH_SCREEN,
    MAIN_SCREEN
}