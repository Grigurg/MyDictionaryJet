package com.grig.mydictionaryjet.presentation.words_show.words_note

import com.grig.mydictionaryjet.presentation.words_show.common.WordsListState

data class WordsNoteState(
    val title: String = "",
    val wordsListState: WordsListState = WordsListState()
)