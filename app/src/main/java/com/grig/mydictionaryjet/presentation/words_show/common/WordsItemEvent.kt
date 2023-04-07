package com.grig.mydictionaryjet.presentation.words_show.common

sealed class WordsItemEvent {
    data class ClickTalker(val id: Int) : WordsItemEvent()
    data class ClickItem(val id: Int) : WordsItemEvent()
}