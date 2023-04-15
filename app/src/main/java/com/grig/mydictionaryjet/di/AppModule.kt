package com.grig.mydictionaryjet.di

import android.app.Application
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.grig.mydictionaryjet.data.database.WordsNoteDatabase
import com.grig.mydictionaryjet.data.database.WordsTypeConverters
import com.grig.mydictionaryjet.data.remote.talker.MediaHelper
import com.grig.mydictionaryjet.data.repository.notes.WordsNotesRepositoryImpl
import com.grig.mydictionaryjet.data.repository.words.WordsRepositoryImpl
import com.grig.mydictionaryjet.domain.repository.WordsNotesRepository
import com.grig.mydictionaryjet.domain.repository.WordsRepository
import com.grig.mydictionaryjet.domain.use_case.notes.*
import com.grig.mydictionaryjet.domain.use_case.words.GetWordsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWordsTypeConverters(): WordsTypeConverters {
        return WordsTypeConverters()
    }

    @Provides
    @Singleton
    fun provideDatabaseReference(): DatabaseReference {
        return FirebaseDatabase.getInstance().reference

    }

    @Provides
    @Singleton
    fun provideWordsRepository(ref: DatabaseReference): WordsRepository {
        return WordsRepositoryImpl(ref)
    }

    @Provides
    @Singleton
    fun provideGetWordsUseCase(repository: WordsRepository): GetWordsUseCase {
        return GetWordsUseCase(repository)
    }

//    @Provides
//    @Singleton
//    fun provideGetWordsNotesRepository(): WordsNotesRepository {
//        return WordsNotesRepositoryFakeImpl()
//    }

    @Provides
    @Singleton
    fun provideWordsNotesUseCases(repository: WordsNotesRepository): WordsNotesUseCases {
        return WordsNotesUseCases(
            getWordsNotes = GetWordsNotes(repository),
            getWordsNote = GetWordsNote(repository),
            insertWordsNote = InsertWordsNote(repository),
            deleteWordsNote = DeleteWordsNote(repository)
        )
    }

    @Provides
    @Singleton
    fun provideMediaHelper(context: Application): MediaHelper {
        return MediaHelper(context)
    }

    @Provides
    @Singleton
    fun provideWordsNoteDatabase(context: Application): WordsNoteDatabase {
        return WordsNoteDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideWordsNoteRepository(db: WordsNoteDatabase): WordsNotesRepository {
        return WordsNotesRepositoryImpl(db.wordsNoteDao())
    }
}