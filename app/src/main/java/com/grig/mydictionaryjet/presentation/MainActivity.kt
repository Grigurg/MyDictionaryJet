package com.grig.mydictionaryjet.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.grig.mydictionaryjet.presentation.theme.MyDictionaryJetTheme
import com.grig.mydictionaryjet.presentation.words_show.WordsListViewModel
import com.grig.mydictionaryjet.presentation.words_show.components.WordsList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val wordsListViewModel by viewModels<WordsListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyDictionaryJetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WordsList(wordsListViewModel)
                }
            }
        }
    }
}