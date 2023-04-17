package com.grig.mydictionaryjet.presentation.words_show.common

sealed class WordsItemEvent {
    object ClickTalker : WordsItemEvent()
    object ClickItem : WordsItemEvent()
}