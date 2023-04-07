package com.grig.mydictionaryjet.presentation.home

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object WordsNoteScreen : Screen("words_note_screen")
    object WordsMainScreen : Screen("words_main_screen")
    object WordsNoteEditScreen : Screen("words_note_edit_screen")
}