package com.grig.mydictionaryjet.data.repository.words

import com.grig.mydictionaryjet.data.dto.WordDto
import com.grig.mydictionaryjet.domain.repository.WordsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WordsRepositoryFakeImpl : WordsRepository {
    override suspend fun getWords(): Flow<List<WordDto>> = flow {
        delay(1000)
        emit(
            listOf(
                WordDto("recap", "резюме"),
                WordDto("reveal", "раскрывать"),
                WordDto("camel", "верблюд"),
                WordDto("iron", "железо, утюг, гладить", "Iron man"),
                WordDto("staff", "персонал"),
                WordDto("owe", "быть должным"),
            )
        )
    }
}