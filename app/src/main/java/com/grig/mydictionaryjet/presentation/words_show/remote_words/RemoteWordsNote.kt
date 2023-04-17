package com.grig.mydictionaryjet.presentation.words_show.remote_words

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.grig.mydictionaryjet.presentation.words_show.common.components.WordsList

@Composable
fun RemoteWordsNote(viewModel: RemoteWordsNoteViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    WordsList(words = state.words, mediaHelper = viewModel.mediaHelper)
}