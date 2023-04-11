package com.grig.mydictionaryjet.presentation.words_edit.components

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun TransparentTextFiled(
    value: String,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle()
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = textStyle.copy(color = MaterialTheme.colors.onSurface)
    )
}