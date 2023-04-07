package com.grig.mydictionaryjet.data.repository.notes

import com.grig.mydictionaryjet.data.database.WordsNoteDao
import com.grig.mydictionaryjet.domain.model.WordsNote
import com.grig.mydictionaryjet.domain.repository.WordsNotesRepository
import kotlinx.coroutines.flow.Flow

class WordsNotesRepositoryImpl(
    private val dao: WordsNoteDao
) : WordsNotesRepository {
    override suspend fun getWordsNotes(): Flow<List<WordsNote>> {
        return dao.getWordsNotes()
    }

    override suspend fun getWordsNoteByTitle(title: String): WordsNote {
        return dao.getWordsNoteByTitle(title)
    }

    override suspend fun insertWordsNote(wordsNote: WordsNote) {
        dao.insertWordsNote(wordsNote)
    }

    override suspend fun deleteWordsNote(wordsNote: WordsNote) {
        dao.deleteWordsNote(wordsNote)
    }
}