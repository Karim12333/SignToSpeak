package com.mobilearchitects.signtospeak

import MainScreen
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mobilearchitects.signtospeak.screens.authenticationScreens.SplashScreen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.mobilearchitects.signtospeak.navigation.BottomNavigationBarComposable
import com.mobilearchitects.signtospeak.navigation.BottomNavigationItem
import com.mobilearchitects.signtospeak.screens.mainpage.HomeScreen
import com.mobilearchitects.signtospeak.screens.mainpage.MainCamScreen
import com.mobilearchitects.signtospeak.screens.mainpage.MainPageScreen
import com.mobilearchitects.signtospeak.ui.theme.AppLightestBlue
import com.mobilearchitects.signtospeak.ui.theme.SignToSpeakTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val items = listOf(
//                BottomNavigationItem(
//                    title = "Learn",
//                    selectedIcon = painterResource(id = R.drawable.selected_book),
//                    unselectedIcon = painterResource(id = R.drawable.ic_book),
//                    hasNews = false
//                ),
//                BottomNavigationItem(
//                    title = "",
//                    selectedIcon = painterResource(id = R.drawable.home_button_bigger),
//                    unselectedIcon = painterResource(id =R.drawable.unselected_home_button),
//                    hasNews = false
//                ),
//                BottomNavigationItem(
//                    title = "Profile",
//                    selectedIcon = painterResource(id = R.drawable.selected_profile),
//                    unselectedIcon = painterResource(id =R.drawable.ic_profile),
//                    hasNews = false
//                ) )

            SignToSpeakTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainPageScreen()
                }
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Navigation()
//                }
//                var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
//
//                Scaffold(
//                    bottomBar = {
//                        BottomNavigationBarComposable(
//                            items = items,
//                            selectedItemIndex = selectedItemIndex,
//                            onItemSelected = { index -> selectedItemIndex = index }
//                        )
//                    },
//                    containerColor = AppLightestBlue,
//                ) {}
            }
        }
    }
}

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splashScreen") {
        composable("splashScreen"){
            SplashScreen(navController = navController)
        }
        composable("HomeScreen"){
            MainScreen(navController = navController)
        }
    }
}

