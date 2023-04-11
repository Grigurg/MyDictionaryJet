package com.grig.mydictionaryjet.data.database

import android.util.Log
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.grig.mydictionaryjet.domain.model.Word
import com.grig.mydictionaryjet.domain.model.WordsNote

class WordsTypeConverters {
    @TypeConverter
    fun fromWordsList(value: List<Word>): String {
        return WordsNote.wordsToString(value)
    }

    @TypeConverter
    fun toWordsList(value: String): List<Word> {
        return WordsNote.wordsFromString(value)
    }
}