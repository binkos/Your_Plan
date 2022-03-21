package com.vladoleg.plantracker.onboarding.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.vladoleg.plantracker.coreui.utils.gradientBackground
import com.vladoleg.plantracker.onboarding.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(toMainScreen: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .gradientBackground(listOf(Color(0xFFff1b49), Color(0xFFe67d20)), 135f),
        contentAlignment = Alignment.Center
    ) {
        val scope = rememberCoroutineScope()
        Icon(
            painter = painterResource(id = R.drawable.icon_tree),
            contentDescription = "Splash icon",
        )

        SideEffect {
            scope.launch {
                delay(3000L)
                toMainScreen()
            }
        }
    }
}