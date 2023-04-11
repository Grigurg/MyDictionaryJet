package com.grig.mydictionaryjet.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.grig.mydictionaryjet.domain.model.WordsNote

//@Database(
//    entities = [WordsNote::class],
//    version = 1
//)
//@TypeConverters(WordsTypeConverters::class)
//abstract class WordsNoteDatabase: RoomDatabase() {
//    abstract val wordsNoteDao: WordsNoteDao
//
//    companion object {
//        const val DATABASE_NAME = "words_notes_db"
//    }
//}

@Database(entities = [WordsNote::class], version = 1, exportSchema = false)
@TypeConverters(WordsTypeConverters::class)
abstract class WordsNoteDatabase : RoomDatabase() {
    abstract fun wordsNoteDao(): WordsNoteDao

    companion object {
        @Volatile
        private var INSTANCE: WordsNoteDatabase? = null

        fun getDatabase(context: Context): WordsNoteDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordsNoteDatabase::class.java,
                    "words_note_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}