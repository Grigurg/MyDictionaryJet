package com.grig.mydictionaryjet.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.grig.mydictionaryjet.domain.model.WordsNote
import com.grig.mydictionaryjet.presentation.home.WordsNoteItemEvent

@Composable
fun WordsNotesList(
    wordsNotes: List<WordsNote>,
    modifier: Modifier = Modifier,
    onItemEvent: (WordsNoteItemEvent) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(wordsNotes) { wordsNote ->
            WordsNoteItem(
                wordsNote = wordsNote,
                onEvent = { event -> onItemEvent(event) }
            )
        }
    }
}