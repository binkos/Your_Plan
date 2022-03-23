package com.vladoleg.plantracker.main.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.vladoleg.plantracker.main.R

@Composable
fun MainScreen() {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        modifier = Modifier,
        scaffoldState = scaffoldState,
        bottomBar = { MainBottomBar() }
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "MAIN SCREEN")
        }
    }
}

@Composable
fun MainBottomBar() {
    var items by remember { mutableStateOf(createBottomItems()) }

// test ограничения appContext

    BottomNavigation {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                selected = item.isItemSelected,
                onClick = { items = items.activate(index) },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = item.labelId.toString()
                    )
                },
                label = { Text(stringResource(id = item.labelId)) }
            )
        }
    }
}

private fun createBottomItems(): List<BottomNavigationItem> =
    listOf(
        BottomNavigationItem(true, R.drawable.ic_whiteboard, R.string.whiteboard),
        BottomNavigationItem(false, R.drawable.ic_profile, R.string.profile),
        BottomNavigationItem(false, R.drawable.ic_notifications, R.string.notifications),
        BottomNavigationItem(false, R.drawable.ic_more, R.string.more),
    )

private fun List<BottomNavigationItem>.activate(id: Int): List<BottomNavigationItem> {
    if (get(id).isItemSelected) return this

    return mapIndexed { index, item ->
        when {
            id == index -> item.copy(isItemSelected = true)
            item.isItemSelected -> item.copy(isItemSelected = false)
            else -> item
        }
    }
}