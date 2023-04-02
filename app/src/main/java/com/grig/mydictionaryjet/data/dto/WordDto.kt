package com.grig.mydictionaryjet.data.dto

import com.grig.mydictionaryjet.domain.model.Word

data class WordDto(
    val engWord: String? = null,
    val rusWord: String? = null,
    val example: String? = null,
)

fun WordDto.toWord(): Word {
    if (engWord == null || rusWord == null) {
        throw NullFiledException("EngWord or rusWord can't be null.")
    }
    return Word(
        engWord = engWord,
        rusWord = rusWord,
        example = example
    )
}

class NullFiledException(msg: String) : Exception(msg)