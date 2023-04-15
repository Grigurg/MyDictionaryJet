package com.grig.mydictionaryjet.presentation.home.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.grig.mydictionaryjet.domain.model.WordsNote
import com.grig.mydictionaryjet.presentation.home.WordsNoteItemEvent

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WordsNoteItem(
    wordsNote: WordsNote,
    modifier: Modifier = Modifier,
    onEvent: (WordsNoteItemEvent) -> Unit = {}
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .combinedClickable(
                onLongClick = {
                    onEvent(WordsNoteItemEvent.EditWordsNote(wordsNote.title))
                },
                onClick = {
                    onEvent(WordsNoteItemEvent.ClickWordsNote(wordsNote.title))
                }
            )
            .background(color = MaterialTheme.colors.surface.copy(alpha = 1f))
    ) {
        Column(
            modifier = Modifier.padding(top = 8.dp, bottom = 12.dp)
        ) {
            Text(
                text = wordsNote.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = buildString {
                    for (word in wordsNote.content) {
                        append(word.toString() + "\n")
                    }
                },
                style = MaterialTheme.typography.body2.copy(
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.75f)
                ),
                modifier = Modifier.padding(start = 5.dp),
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )
        }
        IconButton(
            onClick = { onEvent(WordsNoteItemEvent.DeleteWordsNote(wordsNote)) },
            modifier = Modifier
                .size(30.dp)
                .align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Edit note icon",
                Modifier.size(20.dp)
            )
        }
    }
}