package com.grig.mydictionaryjet.domain.repository

import com.grig.mydictionaryjet.data.dto.WordDto
import kotlinx.coroutines.flow.Flow

interface WordsRepository {
    suspend fun getWords(): Flow<List<WordDto>>
}