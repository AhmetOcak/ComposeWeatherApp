package com.composeweatherapp.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.composeweatherapp.presentation.home.HomeScreen
import com.composeweatherapp.presentation.home.HomeViewModel
import com.composeweatherapp.presentation.search.SearchCityScreen

@Composable
fun NavGraph(startDestination: String = NavScreen.HomeScreen.route, viewModel: HomeViewModel) {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = startDestination
        ) {
            composable(NavScreen.HomeScreen.route) {
                HomeScreen(viewModel) { navController.navigate(NavScreen.SearchCityScreen.route) }
            }
            composable(NavScreen.SearchCityScreen.route) {
                SearchCityScreen {
                    navController.navigate(NavScreen.HomeScreen.route) {
                        launchSingleTop = true
                        popUpTo(NavScreen.HomeScreen.route)
                    }
                }
            }
        }
    }
}