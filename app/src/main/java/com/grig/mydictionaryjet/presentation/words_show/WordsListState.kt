package com.grig.mydictionaryjet.presentation.words_show

import com.grig.mydictionaryjet.domain.model.Word

data class WordsListState(
    val isLoading: Boolean = false,
    val words: List<Word> = emptyList(),
    val error: String = "",
//    val speakingWordIds: List<Int> = emptyList(),
//    val expandedWordIds: List<Int> = emptyList()
)