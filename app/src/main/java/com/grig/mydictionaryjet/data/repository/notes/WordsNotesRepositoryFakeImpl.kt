package com.grig.mydictionaryjet.data.repository.notes

import com.grig.mydictionaryjet.domain.model.WordsNote
import com.grig.mydictionaryjet.domain.repository.WordsNotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WordsNotesRepositoryFakeImpl @Inject constructor(
    private val wordsNotes: List<WordsNote>
) : WordsNotesRepository {

    override suspend fun getWordsNotes(): Flow<List<WordsNote>> = flow {
        emit(wordsNotes)
    }

    override suspend fun getWordsNoteByTitle(title: String): WordsNote {
        return when (title) {
            "Words from TT" -> wordsNotes[0]
            "Words from books" -> wordsNotes[1]
            "Words from songs" -> wordsNotes[2]
            else -> wordsNotes[0]
        }
    }

    override suspend fun insertWordsNote(wordsNote: WordsNote) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWordsNote(wordsNote: WordsNote) {
        TODO("Not yet implemented")
    }
}