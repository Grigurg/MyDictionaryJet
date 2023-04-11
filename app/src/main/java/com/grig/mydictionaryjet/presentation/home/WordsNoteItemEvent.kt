package com.grig.mydictionaryjet.presentation.home

import com.grig.mydictionaryjet.domain.model.WordsNote

sealed class WordsNoteItemEvent {
    data class ClickWordsNote(val title: String): WordsNoteItemEvent()
    data class EditWordsNote(val title: String): WordsNoteItemEvent()
    data class DeleteWordsNote(val wordsNote: WordsNote): WordsNoteItemEvent()
}