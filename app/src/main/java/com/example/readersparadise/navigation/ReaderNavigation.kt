package com.example.readersparadise.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.readersparadise.screens.ReaderSplashScreen
import com.example.readersparadise.screens.home.Home
import com.example.readersparadise.screens.login.ReaderLoginScreen
import com.example.readersparadise.screens.search.SearchScreen
import com.example.readersparadise.screens.stats.ReaderStatsScreen
import com.example.readersparadise.screens.tutorial.FirstPage
import com.example.readersparadise.screens.tutorial.SecondPage

@Composable
fun ReaderNavigation () {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ReaderScreens.SplashScreen.name
    ) {
        composable(ReaderScreens.SplashScreen.name) {
            ReaderSplashScreen(navController = navController)
        }
        composable(ReaderScreens.ReaderHomeScreen.name) {
            Home(navController = navController)
        }
        composable(ReaderScreens.LoginScreen.name) {
            ReaderLoginScreen(navController = navController)
        }
        composable(ReaderScreens.SearchScreen.name) {
            SearchScreen(navController = navController)
        }
        composable(ReaderScreens.ReaderStatsScreen.name) {
           ReaderStatsScreen (navController = navController)
        }
        composable(ReaderScreens.BookDetails.name) {
            ReaderStatsScreen (navController = navController)
        }
        composable(ReaderScreens.FirstPageT.name) {
            FirstPage (navController = navController)
        }
        composable(ReaderScreens.SecondPageT.name) {
            SecondPage (navController = navController)
        }



    }
}
