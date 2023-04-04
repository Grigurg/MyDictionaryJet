package com.grig.mydictionaryjet.presentation.words_show.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.grig.mydictionaryjet.presentation.words_show.WordsListViewModel

@Composable
fun WordsList(
    viewModel: WordsListViewModel
) {
    val state by viewModel.state.collectAsState()
//    val expandedWordIds by viewModel.expandedWordIds.collectAsState()
//    val speakingWordIds by viewModel.speakingWordIds.collectAsState()

    val expandedWordIds = state.expandedWordIds
    val speakingWordIds = state.speakingWordIds

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 7.dp)
                .padding(horizontal = 6.dp), verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            itemsIndexed(state.words) { index, _ ->
                Log.d("MyLog", index.toString())
                WordItem(expanded = expandedWordIds.contains(index),
                    speaking = speakingWordIds.contains(index),
                    word = state.words[index],
                    ind = index,
                    onEvent = { event -> viewModel.onEvent(event) })
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
