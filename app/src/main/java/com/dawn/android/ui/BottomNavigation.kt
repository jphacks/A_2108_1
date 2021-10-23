package com.dawn.android.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.BookmarkBorder
import androidx.compose.material.icons.twotone.Face
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material.icons.twotone.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dawn.android.R
import com.dawn.android.ui.theme.DawnTheme
import com.dawn.android.ui.theme.White

enum class BottomNavItems(
    val selectedIconResId: Int,
    val unSelectedIcon: ImageVector,
) {
    Home(
        selectedIconResId = R.drawable.ic_home,
        unSelectedIcon = Icons.TwoTone.Home,
    ),
    Search(
        selectedIconResId = R.drawable.ic_search,
        unSelectedIcon = Icons.TwoTone.Search,
    ),
    Favorite(
        selectedIconResId = R.drawable.ic_bookmark,
        unSelectedIcon = Icons.TwoTone.BookmarkBorder,
    ),
    MyPage(
        selectedIconResId = R.drawable.ic_face,
        unSelectedIcon = Icons.TwoTone.Face,
    );

    val route = name

    @Composable
    fun Image(selected: Boolean) {
        if (selected) {
            Image(
                painter = painterResource(id = selectedIconResId),
                contentDescription = null,
            )
        } else {
            Icon(
                imageVector = unSelectedIcon,
                contentDescription = null,
                tint = Color(0xFFACACAC)
            )
        }
    }
}

@Composable
fun AppBottomNavigation() {
    val navController = LocalNav.current
    navController.currentBackStackEntryAsState()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    BottomNavigation(
        backgroundColor = White,
    ) {
        BottomNavItems.values().forEach { item ->
            val selected = currentBackStackEntry?.destination?.hierarchy?.any { it.route == item.route } == true
            BottomNavigationItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                    }
                },
                icon = {
                    item.Image(selected = selected)
                },
            )
        }
    }
}

@Composable
@Preview
fun BottomNavPreview() {
    DawnTheme {
        Column {
            BottomNavigation(
                backgroundColor = White,
            ) {
                BottomNavItems.values().forEach { item ->
                    val selected = item == BottomNavItems.Home
                    BottomNavigationItem(
                        selected = selected,
                        onClick = { /*TODO*/ },
                        icon = {
                            item.Image(selected = selected)
                        },
                    )
                }
            }
        }
    }
}
