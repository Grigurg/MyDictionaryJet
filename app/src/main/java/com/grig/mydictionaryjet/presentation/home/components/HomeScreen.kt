package com.grig.mydictionaryjet.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.grig.mydictionaryjet.presentation.home.HomeViewModel
import com.grig.mydictionaryjet.presentation.home.Screen

@Composable
fun HomeScreen(viewModel: HomeViewModel, navController: NavController) {
    val wordsNotes by viewModel.wordsNotes.collectAsState()

    Column {
        WordsNoteMainItem(
            modifier = Modifier.clickable {
                navController.navigate(Screen.ShowWordsScreen.route)
            }
        )
        WordsNotesList(
            wordsNotes = wordsNotes,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp)
                .padding(horizontal = 5.dp)
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
