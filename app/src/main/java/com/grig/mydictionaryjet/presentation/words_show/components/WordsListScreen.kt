package com.grig.mydictionaryjet.presentation.words_show.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.grig.mydictionaryjet.presentation.words_show.WordsListViewModel

@Composable
fun WordsList(
    viewModel: WordsListViewModel
) {
    val words by viewModel.words.collectAsState()
    val expandedWordIds by viewModel.expandedWordIds.collectAsState()
    val speakingWordIds by viewModel.speakingWordIds.collectAsState()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(words.words) { index, item ->
            WordItem(
                expanded = expandedWordIds.contains(index),
                speaking = speakingWordIds.contains(index),
                word = words.words[index],
                ind = index,
                onEvent = { event -> viewModel.onEvent(event) }
            )
        }
    }
}