package com.grig.mydictionaryjet.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.grig.mydictionaryjet.presentation.theme.NoteTitleType

@Composable
fun RemoteWordsNoteItem(
     title: String,
     modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(
                color = MaterialTheme.colors.surface
            )
    ) {
        Text(
            text = title,
            style = NoteTitleType,
            modifier =
            Modifier.fillMaxWidth()
                .padding(vertical = 24.dp)
            ,
            textAlign = TextAlign.Center
        )
    }
}