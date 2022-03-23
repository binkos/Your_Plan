package com.vladoleg.plantracker.main.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

internal data class BottomNavigationItem(
    val isItemSelected: Boolean,
    @DrawableRes val iconId: Int,
    @StringRes val labelId: Int,
)