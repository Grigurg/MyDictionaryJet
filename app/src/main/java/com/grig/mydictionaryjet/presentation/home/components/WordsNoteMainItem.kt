package com.grig.mydictionaryjet.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WordsNoteMainItem(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color = MaterialTheme.colors.surface)
    ) {
        Text(
            text = "English Words",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.align(
                Alignment.Center
            )
        )
    }
}