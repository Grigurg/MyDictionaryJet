package com.grig.mydictionaryjet.data.repository

import com.grig.mydictionaryjet.data.dto.WordDto
import com.grig.mydictionaryjet.domain.repository.WordsRepository

class WordsRepositoryFakeImpl : WordsRepository {
    override suspend fun getWords(): List<WordDto> {
        return listOf(
            WordDto("recap", "резюме"),
            WordDto("reveal", "раскрывать"),
            WordDto("camel"),
            WordDto("iron", "железо, утюг, гладить", "Iron man"),
            WordDto("staff", "персонал"),
            WordDto("owe", "быть должным"),
        )
    }
}