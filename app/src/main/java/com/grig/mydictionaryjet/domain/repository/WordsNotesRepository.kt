package com.grig.mydictionaryjet.domain.repository

import com.grig.mydictionaryjet.domain.model.WordsNote
import kotlinx.coroutines.flow.Flow

interface WordsNotesRepository {
    suspend fun getWordsNotes(): Flow<List<WordsNote>>

    suspend fun getWordsNoteByTitle(title: String): WordsNote

    suspend fun insertWordsNote(wordsNote: WordsNote)

    suspend fun deleteWordsNote(wordsNote: WordsNote)
}