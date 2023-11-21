@file:OptIn(ExperimentalMaterial3Api::class)

package com.mobilearchitects.signtospeak
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.mobilearchitects.signtospeak.ui.screens.mainpage.HomeScreen
import com.mobilearchitects.signtospeak.ui.theme.SignToSpeakTheme

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: Painter,
    val unselectedIcon: Painter,
    val hasNews: Boolean,
    val badgeCount:Int? = null
)


@Composable
fun BottomNavigationBarComposable(
    items: List<BottomNavigationItem>,
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar (containerColor = Color.White){
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = { onItemSelected(index) },
                label = {Text(text = item.title)},
                icon = {
                    BadgedBox(badge = {
                        if (item.hasNews) {
                            Badge()
                        }
                    }) {
                        Icon(
                            painter = if (selectedItemIndex == index) item.selectedIcon else {item.unselectedIcon},
                            contentDescription = item.title,
                            tint = Color.Unspecified,
                            modifier = Modifier.align(Alignment.CenterStart)
                        )

                    }
                }
            )
        }

    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val items = listOf(
                BottomNavigationItem(
                    title = "Learn",
                    selectedIcon = painterResource(id = R.drawable.ic_book),
                    unselectedIcon = painterResource(id = R.drawable.ic_book),
                    hasNews = false
                ),
                BottomNavigationItem(
                    title = "",
                    selectedIcon = painterResource(id = R.drawable.logo_white_small),
                    unselectedIcon = painterResource(id = R.drawable.logo_white_small),
                    hasNews = false
                ),
                BottomNavigationItem(
                    title = "Profile",
                    selectedIcon = painterResource(id = R.drawable.ic_profile),
                    unselectedIcon = painterResource(id = R.drawable.ic_profile),
                    hasNews = false
                )
            )

            SignToSpeakTheme {
                // ... other UI components

                var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
                HomeScreen()
                // The extracted composable function is used here
                Scaffold(
                    bottomBar = {
                        BottomNavigationBarComposable(
                            items = items,
                            selectedItemIndex = selectedItemIndex,
                            onItemSelected = { index -> selectedItemIndex = index }
                        )
                    },
                    containerColor = Color.White,
                ) {}
            }
        }
    }
}

