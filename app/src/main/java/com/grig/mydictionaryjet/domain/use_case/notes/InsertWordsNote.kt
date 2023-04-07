package com.grig.mydictionaryjet.domain.use_case.notes

import com.grig.mydictionaryjet.domain.model.WordsNote
import com.grig.mydictionaryjet.domain.repository.WordsNotesRepository
import javax.inject.Inject

class InsertWordsNote @Inject constructor(
    private val repository: WordsNotesRepository
) {
    suspend operator fun invoke(wordsNote: WordsNote) {
        repository.insertWordsNote(wordsNote)
    }
}