package com.grig.mydictionaryjet.presentation.words_show.common

import com.grig.mydictionaryjet.domain.model.Word

data class WordsListState(
    val words: List<Word> = emptyList(),
    val speakingWordIds: List<Int> = emptyList(),
    val expandedWordIds: List<Int> = emptyList()
)