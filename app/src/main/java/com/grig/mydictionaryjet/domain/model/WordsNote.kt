package com.grig.mydictionaryjet.domain.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WordsNote(
    @PrimaryKey
    val title: String,
    @Embedded
    val content: List<Word> = emptyList()
)