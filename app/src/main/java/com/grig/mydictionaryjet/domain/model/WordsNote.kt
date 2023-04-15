package com.grig.mydictionaryjet.domain.model

import androidx.room.*

//@Entity(tableName = "words_note")
//data class WordsNote(
//    @PrimaryKey
//    val title: String,
//    @Embedded
//    val words: List<Word>
//    )

//@Entity(tableName = "words_note")
//data class WordsNote(
//    @PrimaryKey
//    val title: String,
//    val words: String
//)

//@Entity(tableName = "words_note")
//data class WordsNote(
//    var title: String = "",
//    @Embedded val content: List<Word> = emptyList(),
//    @PrimaryKey(autoGenerate = true) val id: Int = 0
//)


@Entity(tableName = "words_note", indices = [Index(value = ["title"], unique = true)])
data class WordsNote(
    @PrimaryKey var title: String = "",
    val content: String = ""
){
    companion object {
        fun wordsToString(words: List<Word>): String {
            return buildString {
                append(words.first())
                words.drop(1).forEach {
                    append("\n$it")
                }
            }
        }

        fun wordsFromString(string: String): List<Word> {
            return buildList {
                for (line in string.split("\n")) {
                    val word = Word.fromString(line)
                    if (word != null)
                        add(word)
                }
            }
        }
    }
}
//{
//    fun wordsToString(): String {
//        return buildString {
//            words.forEach { append("$it\n") }
//        }
//    }
//
//    fun wordsFromString(string: String): List<Word> {
//        return buildList {
//            for (line in string.split("\n")) {
//                add(Word.fromString(line))
//            }
//        }
//    }
//}

//@Entity(tableName = "notes_table")
//
//@Entity(tableName = "words_note")
//data class WordsNote(
//    var title: String = "",
//    @Embedded val words: List<Word> = emptyList(),
//    @PrimaryKey(autoGenerate = true) val id: Int = 0
//) {
//    fun wordsToString(): String {
//        return buildString {
//            words.forEach { append("$it\n") }
//        }
//    }
//    fun wordsFromString(string: String): List<Word> {
//        return buildList {
//            for (line in string.split("\n")) {
//                add(Word.fromString(line))
//            }
//        }
//    }
//}
//@Entity(tableName = "words_note", indices = [Index(value = ["title"], unique = true)])
//data class WordsNote(
//    @PrimaryKey val title: String = "",
//    val content: List<Word> = emptyList()
//)
