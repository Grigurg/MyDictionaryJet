package com.grig.mydictionaryjet.presentation.words_show.words_main

import com.grig.mydictionaryjet.presentation.words_show.common.WordsListState

data class WordsMainState(
    val isLoading: Boolean = false,
    val error: String = "",
    val wordsListState: WordsListState = WordsListState()
)