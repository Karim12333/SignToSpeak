package com.mobilearchitects.signtospeak.navigation

import androidx.compose.foundation.Image
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.mobilearchitects.signtospeak.ui.theme.AppLightestBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBarComposable(
    items: List<BottomNavigationItem>,
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar (containerColor = AppLightestBlue){
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
                            painter =
                                if (selectedItemIndex == index)
                                    item.selectedIcon
                                else
                                    {item.unselectedIcon},
                            contentDescription = item.title,
                            tint = Color.Unspecified,
                            modifier = Modifier.align(Alignment.CenterStart)
                        )
//                        Image(
//                            painter = painterResource( id =
//                                if (selectedItemIndex == index)
//                                    item.selectedIcon
//                                else
//                                    item.unselectedIcon
//                            ),
//                            contentDescription = item.title,
//                            modifier = Modifier.align(Alignment.CenterStart)
//                        )

                    }
                }
            )
        }

    }
}