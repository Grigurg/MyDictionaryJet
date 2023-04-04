package com.grig.mydictionaryjet.presentation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.grig.mydictionaryjet.presentation.home.HomeViewModel
import com.grig.mydictionaryjet.presentation.home.Screen
import com.grig.mydictionaryjet.presentation.home.components.HomeScreen
import com.grig.mydictionaryjet.presentation.words_show.WordsListViewModel
import com.grig.mydictionaryjet.presentation.words_show.components.WordsList

@Composable
fun Navigation() {
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val wordsListViewModel = viewModel(modelClass = WordsListViewModel::class.java)
//    val

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            HomeScreen(viewModel = homeViewModel, navController)
        }
        composable(Screen.ShowWordsScreen.route) {
            WordsList(viewModel = wordsListViewModel)
        }
    }
}