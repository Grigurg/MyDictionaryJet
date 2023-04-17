package com.grig.mydictionaryjet.domain.repository

import kotlinx.coroutines.flow.Flow

interface WordsNotesRemoteRepository {
    suspend fun getWordsNotesTitles(): Flow<List<String>>
}