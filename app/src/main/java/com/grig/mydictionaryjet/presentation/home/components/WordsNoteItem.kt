package com.grig.mydictionaryjet.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.grig.mydictionaryjet.domain.model.WordsNote

@Composable
fun WordsNoteItem(
    wordsNote: WordsNote,
    modifier: Modifier = Modifier,
    onEditClick: (WordsNote) -> Unit = {},
    onClickItem: (WordsNote) -> Unit = {}
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClickItem(wordsNote) }
            .background(color = MaterialTheme.colors.surface.copy(alpha = 1f))
    ) {
        Column(
            modifier = Modifier.padding(top = 8.dp, bottom = 12.dp)
        ) {
            Text(
                text = wordsNote.title ?: "",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
//                modifier = Modifier.align(Alig)
            )
            Text(
                text = buildString {
                    for (word in wordsNote.words) {
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
            onClick = { onEditClick(wordsNote) },
            modifier = Modifier
                .size(35.dp)
                .align(Alignment.BottomEnd)

//                .offset(5.dp, 5.dp)
//                .padding(end = (-5).dp, bottom = (-5).dp)
//                .padding(end = 5.dp, bottom = 5.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit note icon"
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewWordsNoteItem() {
//    WordsNoteItem(wordsNote = WordsNotesRepositoryFakeImpl.wordsNotes[0])
//}