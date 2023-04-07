package com.grig.mydictionaryjet.domain.use_case.notes

import com.grig.mydictionaryjet.domain.model.WordsNote
import com.grig.mydictionaryjet.domain.repository.WordsNotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetWordsNotes @Inject constructor(
    private val repository: WordsNotesRepository
) {
    suspend operator fun invoke(): Flow<List<WordsNote>> = flow {
        repository.getWordsNotes().collect { wordsNotes ->
            emit(wordsNotes)
        }
    }
}