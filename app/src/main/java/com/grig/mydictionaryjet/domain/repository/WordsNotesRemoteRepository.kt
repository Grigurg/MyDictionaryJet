package com.grig.mydictionaryjet.domain.repository

import com.grig.mydictionaryjet.data.dto.WordsNoteDto
import kotlinx.coroutines.flow.Flow

interface WordsNotesRemoteRepository {
    suspend fun getWordsNotes(): Flow<List<WordsNoteDto>>
}