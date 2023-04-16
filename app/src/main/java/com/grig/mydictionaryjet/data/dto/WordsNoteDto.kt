package com.grig.mydictionaryjet.data.dto

import com.grig.mydictionaryjet.domain.model.WordsNote

data class WordsNoteDto(
    val title: String? = null,
    val words: List<WordDto>? = null
) {
    fun toWordsNote(): WordsNote {
        if (title == null || words == null) {
            throw NullFiledException("Title or words can't be null. Check your firebase requests")
        } // WordsNote.wordsToString( words.map { it.toWord() })
//        for (i in words.map { it.toWord() } ) {
//            Log.d("MyLog", WordsNote.wordsToString( words.map { it.toWord() }))
//        }
        return WordsNote(
            title = title,
            content = WordsNote.wordsToString(words.map { it.toWord() })
        )
    }
}

class NullFiledException(msg: String) : Exception(msg)