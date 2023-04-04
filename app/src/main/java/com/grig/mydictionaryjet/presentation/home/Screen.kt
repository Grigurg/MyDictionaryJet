package com.grig.mydictionaryjet.presentation.home

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object ShowWordsScreen : Screen("show_words_screen")
    object EditWordsScreen : Screen("edit_words_screen")
}