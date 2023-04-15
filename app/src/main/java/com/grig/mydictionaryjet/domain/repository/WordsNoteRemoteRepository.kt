package com.grig.mydictionaryjet.domain.repository

import com.grig.mydictionaryjet.data.dto.WordsNoteDto
import kotlinx.coroutines.flow.Flow

interface WordsNoteRemoteRepository {
    suspend fun getWordsNotes(): Flow<List<WordsNoteDto>>
}