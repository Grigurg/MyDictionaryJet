package com.grig.mydictionaryjet.presentation.home.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.grig.mydictionaryjet.presentation.home.HomeViewModel
import com.grig.mydictionaryjet.presentation.home.Screen

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val wordsNotes by viewModel.wordsNotes.collectAsState()

    Column {
        WordsNoteMainItem(
            modifier = Modifier.clickable {
                navController.navigate(Screen.WordsMainScreen.route)
            }
        )
        WordsNotesList(
            wordsNotes = wordsNotes,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp)
                .padding(horizontal = 5.dp),
            onClickItem = { wordsNote ->
                Log.d("MyLog", "click note")
                navController.navigate(Screen.WordsNoteScreen.route + "/${wordsNote.title}")
            },
            onEditClick = { wordsNote ->
                navController.navigate(Screen.WordsNoteEditScreen.route + "/${wordsNote.title}")
            }
        )
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
