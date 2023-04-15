package com.grig.mydictionaryjet.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.grig.mydictionaryjet.data.repository.VersionControl
import com.grig.mydictionaryjet.presentation.theme.MyDictionaryJetTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var versionControl: VersionControl
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyDictionaryJetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var isDialogOpen by remember {
                        mutableStateOf(false)
                    }
                    LaunchedEffect(true) {
                        delay(2000)
//                        val currentVersion =
                        versionControl.isVersionLatest().thenAccept { isLatest ->
                            isDialogOpen = isLatest
                        }
                    }
                    if (isDialogOpen) {
                        DeprecatedVersionDialog()
                    }
                    Navigation()
                }
            }
        }
    }
}