package com.grig.mydictionaryjet.presentation.words_show

import com.grig.mydictionaryjet.domain.model.Word

data class WordsItemState(
    val word: Word = Word(),
    val isExpanded: Boolean = false,
    val speaking: Boolean = false
)