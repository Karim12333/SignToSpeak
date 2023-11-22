package com.mobilearchitects.signtospeak.navigation

sealed class Screens(val route : String){
    object Learn : Screens("Learn_route")
    object Home : Screens("home_route")
    object Profile : Screens("profile_route")

}
