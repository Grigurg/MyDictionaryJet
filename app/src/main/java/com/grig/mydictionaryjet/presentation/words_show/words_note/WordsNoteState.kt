package com.grig.mydictionaryjet.presentation.words_show.words_note

import com.grig.mydictionaryjet.domain.model.Word

data class WordsNoteState(
    val title: String = "",
    val words: List<Word> = emptyList()
)