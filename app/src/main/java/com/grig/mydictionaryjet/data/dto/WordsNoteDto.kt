package com.grig.mydictionaryjet.data.dto

import com.grig.mydictionaryjet.domain.model.WordsNote

data class WordsNoteDto(
    val title: String? = null,
    val words: List<WordDto>? = null
){
    fun toWordsNote(): WordsNote {
        if (title == null || words == null) {
            throw NullFiledException("Title or words can't be null. Check your firebase requests")
        }
        return WordsNote(
            title = title,
            content = words.map { it.toWord() }.toString()
        )
    }
}

class NullFiledException(msg: String) : Exception(msg)