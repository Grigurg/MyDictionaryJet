package com.grig.mydictionaryjet.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.grig.mydictionaryjet.presentation.home.Screen
import com.grig.mydictionaryjet.presentation.home.components.HomeScreen
import com.grig.mydictionaryjet.presentation.words_edit.components.WordsNoteEdit
import com.grig.mydictionaryjet.presentation.words_show.remote_words.RemoteWordsNote
import com.grig.mydictionaryjet.presentation.words_show.words_note.components.WordsNote

@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController)
        }
//        composable(Screen.WordsMainScreen.route) {
////            val wordsMainViewModel = viewModel(modelClass = WordsMainViewModel::class.java)
////            WordsMain(viewModel = wordsMainViewModel)
//            WordsMain()
//        }
        composable(Screen.WordsNoteScreen.route + "/{title}") {
            WordsNote()
        }
        composable(Screen.RemoteWordsNoteScreen.route + "/{title}") {
            RemoteWordsNote()
        }
        composable(Screen.WordsNoteEditScreen.route + "?title={title}") {
            WordsNoteEdit()
        }
    }
}