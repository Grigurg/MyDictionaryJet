package com.grig.mydictionaryjet.di

import android.app.Application
import com.google.firebase.database.FirebaseDatabase
import com.grig.mydictionaryjet.data.database.WordsNoteDatabase
import com.grig.mydictionaryjet.data.database.WordsTypeConverters
import com.grig.mydictionaryjet.data.remote.talker.MediaHelper
import com.grig.mydictionaryjet.data.repository.VersionControl
import com.grig.mydictionaryjet.data.repository.notes.WordsNotesRepositoryImpl
import com.grig.mydictionaryjet.data.repository.words.WordsNoteRemoteRepositoryImpl
import com.grig.mydictionaryjet.domain.repository.WordsNoteRemoteRepository
import com.grig.mydictionaryjet.domain.repository.WordsNotesRepository
import com.grig.mydictionaryjet.domain.use_case.database.*
import com.grig.mydictionaryjet.domain.use_case.remote.GetWordsNotesRemoteUseCase
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
    fun provideFirebaseDatabase(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()

    }

    @Provides
    @Singleton
    fun provideWordsNoteRemoteRepository(db: FirebaseDatabase): WordsNoteRemoteRepository {
        return WordsNoteRemoteRepositoryImpl(db)
    }

    @Provides
    @Singleton
    fun provideGetWordsUseCase(repository: WordsNoteRemoteRepository): GetWordsNotesRemoteUseCase {
        return GetWordsNotesRemoteUseCase(repository)
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

    @Provides
    @Singleton
    fun provideVersionControl(db: FirebaseDatabase): VersionControl {
        return VersionControl(db)
    }
}