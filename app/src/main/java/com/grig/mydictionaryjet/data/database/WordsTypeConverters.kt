package com.grig.mydictionaryjet.data.database

import android.util.Log
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.grig.mydictionaryjet.domain.model.Word

//class WordsTypeConverters {
//    @TypeConverter
//    fun fromWordsList(value: List<Word>): String {
//        val gson = Gson()
//        Log.d("MyLog", gson.toJson(value))
//        return gson.toJson(value)
//    }
//
//    @TypeConverter
//    fun toWordsList(value: String): List<Word> {
//        val listType = object : TypeToken<List<Word>>() {}.type
//        return Gson().fromJson(value, listType)
//    }
//}