package com.grig.mydictionaryjet.domain.repository

import com.grig.mydictionaryjet.data.dto.WordDto

interface WordsRepository {
    suspend fun getWords(): List<WordDto>
}