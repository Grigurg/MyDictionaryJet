package com.grig.mydictionaryjet.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.grig.mydictionaryjet.presentation.home.HomeViewModel
import com.grig.mydictionaryjet.presentation.home.Screen
import com.grig.mydictionaryjet.presentation.home.WordsNoteItemEvent

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val wordsNotes by viewModel.wordsNotes.collectAsState()

    LaunchedEffect(wordsNotes) {
        if (wordsNotes.isNotEmpty()) {
            navController.navigate(Screen.WordsNoteEditScreen.route + "/${wordsNotes[0].title}")
        }
    }

    Column {
        WordsNoteMainItem(modifier = Modifier.clickable {
            navController.navigate(Screen.WordsMainScreen.route)
        })
        WordsNotesList(wordsNotes = wordsNotes,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp)
                .padding(horizontal = 5.dp),
            onItemEvent = { event ->
                when (event) {
                    is WordsNoteItemEvent.ClickWordsNote ->
                        navController.navigate(Screen.WordsNoteScreen.route + "/${event.title}")
                    is WordsNoteItemEvent.EditWordsNote ->
                        navController.navigate(Screen.WordsNoteEditScreen.route + "/${event.title}")
                    is WordsNoteItemEvent.DeleteWordsNote ->
                        viewModel.deleteWordsNote(event.wordsNote)
                }
            })
    }

//    Box(modifier = Modifier.fillMaxSize()) {
//        Text(
//            text = "This is the home page",
//            style = MaterialTheme.typography.h5,
//            modifier = Modifier.align(
//                Alignment.Center
//            )
//        )
//    }
}
