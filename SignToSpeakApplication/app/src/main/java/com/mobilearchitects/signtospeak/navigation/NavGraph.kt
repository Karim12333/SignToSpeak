package com.mobilearchitects.signtospeak.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController){
    NavHost(navController = navController,
            route = Graph.Home,
            startDestination = Graph.Home
    ){
        composable(route = Graph.Home){

        }
    }
}


object Graph {
    const val Home = "home"
    const val Profile = "profile"
}