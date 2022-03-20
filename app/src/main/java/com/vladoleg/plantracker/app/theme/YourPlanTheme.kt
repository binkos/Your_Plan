package com.vladoleg.plantracker.app.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.vladoleg.plantracker.coreui.theme.DarkColorPalette
import com.vladoleg.plantracker.coreui.theme.LightColorPalette
import com.vladoleg.plantracker.coreui.theme.Shapes
import com.vladoleg.plantracker.coreui.theme.Typography

@Composable
fun YourPlanTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}