package com.grig.mydictionaryjet.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DeprecatedVersionDialog() {
    AlertDialog(
        onDismissRequest = { },
        title = {
            Box(modifier = Modifier.height(100.dp)) {
                Column(modifier = Modifier.align(Center)) {
                    Text(
                        text = "Your version of app has deprecated",
                        color = MaterialTheme.colors.error,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Download and install apk from url",
                    )
                }
            }
        },
        buttons = {}
    )
}