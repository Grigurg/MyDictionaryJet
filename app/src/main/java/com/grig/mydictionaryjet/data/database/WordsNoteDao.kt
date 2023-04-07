package com.grig.mydictionaryjet.data.database

import androidx.room.*
import com.grig.mydictionaryjet.domain.model.WordsNote
import kotlinx.coroutines.flow.Flow

@Dao
interface WordsNoteDao {

    @Query("SELECT * FROM words_note")
    fun getWordsNotes(): Flow<List<WordsNote>>

    @Query("SELECT * FROM words_note WHERE title = :title")
    suspend fun getWordsNoteByTitle(title: String): WordsNote

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordsNote(wordsNote: WordsNote)

    @Delete
    suspend fun deleteWordsNote(wordsNote: WordsNote)
}