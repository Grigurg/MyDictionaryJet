package com.grig.mydictionaryjet.presentation.words_edit.components

sealed class WordsNoteEditEvent {
    data class TitleChanged(val title: String): WordsNoteEditEvent()
    data class ContentChanged(val content: String): WordsNoteEditEvent()
}
