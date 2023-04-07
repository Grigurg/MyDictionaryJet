package com.grig.mydictionaryjet.domain.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

//@Entity(tableName = "words_note")
//data class WordsNote(
//    @PrimaryKey
//    val title: String,
//    @Embedded
//    val words: List<Word>
//    )

@Entity(tableName = "words_note")
data class WordsNote(
    @PrimaryKey
    val title: String,
    @Embedded(prefix = "words_")
    @Relation(
        parentColumn = "title",
        entityColumn = "words_note_title"
    )
    val words: List<Word>
)

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
