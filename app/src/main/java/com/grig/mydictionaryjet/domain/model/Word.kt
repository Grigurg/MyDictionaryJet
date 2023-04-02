package com.grig.mydictionaryjet.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Word(
    val engWord: String = "",
    val rusWord: String = "",
    val example: String? = null,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)