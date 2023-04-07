package com.grig.mydictionaryjet.presentation.words_edit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.grig.mydictionaryjet.presentation.words_edit.WordsNoteEditViewModel

@Composable
fun WordsNoteEdit(
    viewModel: WordsNoteEditViewModel = hiltViewModel()
) {
    val wordsNote by viewModel.wordsNote.collectAsState()
    Column(Modifier.fillMaxSize()) {
        TransparentTextFiled(
            value = wordsNote.title,
            onValueChange = { wordsNote.title = it }
        )
        TransparentTextFiled(
            value = wordsNote.title,
            onValueChange = { }
        )
    }
}