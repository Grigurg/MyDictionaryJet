package com.grig.mydictionaryjet.presentation.words_edit.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun TransparentTextFiled(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle(),
    hint: String = ""
) {
    val colors = TextFieldDefaults.textFieldColors(
        backgroundColor = Color.Transparent,
        textColor = MaterialTheme.colors.onSurface.copy(alpha = 0.85f),
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent
    )
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        colors = colors,
        textStyle = textStyle,
        placeholder = { Text(text = hint) }
    )
}