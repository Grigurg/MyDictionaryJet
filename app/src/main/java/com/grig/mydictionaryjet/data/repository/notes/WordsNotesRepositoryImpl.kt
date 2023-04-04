package com.grig.mydictionaryjet.data.repository.notes

import com.grig.mydictionaryjet.domain.model.WordsNote
import com.grig.mydictionaryjet.domain.repository.WordsNotesRepository
import kotlinx.coroutines.flow.Flow

class WordsNotesRepositoryImpl : WordsNotesRepository {
    override suspend fun getWordsNotes(): Flow<List<WordsNote>> {
        TODO("Not yet implemented")
    }

    override suspend fun getWordsNoteByTitle(title: String): WordsNote {
        TODO("Not yet implemented")
    }

    override suspend fun insertWordsNote(wordsNote: WordsNote) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWordsNote(wordsNote: WordsNote) {
        TODO("Not yet implemented")
    }
}