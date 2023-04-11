package com.grig.mydictionaryjet.domain.model

import android.util.Log
import androidx.compose.runtime.isTraceInProgress
import androidx.room.Entity
import com.grig.mydictionaryjet.data.database.WordsTypeConverters

//@Entity(tableName = "words_table")
//data class Word(
////    @PrimaryKey
//    val engWord: String,
//    val rusWord: String,
//    val example: String? = null,
////    @PrimaryKey(autoGenerate = true) val id: Int = 0
////    ,
//) {
//    override fun toString(): String {
//        return if (example.isNullOrBlank()) {
//            "$engWord - $rusWord"
//        } else {
//            "$engWord - $rusWord + $example"
//        }
//    }
//    // camel - верблюд + camel eating grass
//    companion object {
//        fun fromString(str: String): Word {
//            val (engWord, rest) = str.split('-')
//            val (rusWord, example) = rest.split(" + ")
//
//            Log.d("MyLog", "$engWord - $rusWord + $example")
//            return Word(engWord, rusWord, example.takeIf { example.isNotBlank() })
//        }
//    }
//}

data class Word(
    val engWord: String,
    val rusWord: String,
    val example: String? = null
) {
    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(engWord).append(" - ").append(rusWord)
        return "$engWord - $rusWord" + (example?.let { " + $it" } ?: "")
    }
        companion object {
        fun fromString(input: String): Word? {
            return try {
                val parts = input.split(" - ", " + ")
                val (engWord, rusWord) = parts[0] to parts[1]
                val example = parts.getOrNull(2)
                Word(engWord, rusWord, example)
            } catch (ex: Exception) {
                null
            }
        }
    }
}

//data class Word(
//    val engWord: String = "",
//    val rusWord: String = "",
//    val example: String? = null
//) {
////    constructor(engWord: String, rusWord: String, example: String?) : this(engWord, rusWord, example)
////    constructor(): this("", "")
//
//    override fun toString(): String {
//        return "$engWord - $rusWord ${example?.let { " + $it" }}}"
//    }
//    // camel - верблюд + camel eating grass
//    companion object {
//        fun fromString(str: String): Word {
//            val (engWord, rest) = str.split('-')
//            val (rusWord, example) = rest.split(" + ")
//
//            Log.d("MyLog", "$engWord - $rusWord + $example")
//            return Word(engWord, rusWord, example.takeIf { example.isNotBlank() })
//        }
//    }
//}

//@Entity
//data class Word(
//    val engWord: String = "",
//    val rusWord: String = "",
//    val example: String? = null,
//    @PrimaryKey(autoGenerate = true)
//    val id: Int? = null
//) {
//    override fun toString(): String {
//        return if (example.isNullOrBlank()) {
//            "$engWord - $rusWord"
//        } else {
//            "$engWord - $rusWord + $example"
//        }
//    }
//}