package com.grig.mydictionaryjet.domain.use_case.database

import com.grig.mydictionaryjet.domain.model.WordsNote
import com.grig.mydictionaryjet.domain.repository.WordsNotesRepository
import javax.inject.Inject

class GetWordsNote @Inject constructor(
    private val repository: WordsNotesRepository
) {
    suspend operator fun invoke(title: String): WordsNote {
        return repository.getWordsNoteByTitle(title)
    }
}