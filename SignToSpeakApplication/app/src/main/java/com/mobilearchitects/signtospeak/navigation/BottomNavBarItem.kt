package com.mobilearchitects.signtospeak.navigation

//import androidx.compose.ui.graphics.painter.Painter
//import androidx.compose.ui.res.painterResource
//import com.mobilearchitects.signtospeak.R

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: Painter,
    val unselectedIcon: Painter,
    val hasNews: Boolean,
    val badgeCount:Int? = null
)
//{
    //function to get the list of bottomNavigationItems
//    fun bottomNavigationItems() : List<BottomNavigationItem> {
//        return listOf(
//            BottomNavigationItem(
//                title = "Learn",
//                selectedIcon = R.drawable.selected_book,
//                unselectedIcon = R.drawable.ic_book,
//                hasNews = false
//            ),
//            BottomNavigationItem(
//                title = "",
//                selectedIcon = R.drawable.home_button_bigger,
//                unselectedIcon = R.drawable.unselected_home_button,
//                hasNews = false
//            ),
//            BottomNavigationItem(
//                title = "Profile",
//                selectedIcon = R.drawable.selected_profile,
//                unselectedIcon = R.drawable.ic_profile,
//                hasNews = false
//            ),
//        )
//    }
//}