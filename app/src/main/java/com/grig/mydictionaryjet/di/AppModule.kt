package com.grig.mydictionaryjet.di

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.grig.mydictionaryjet.data.repository.notes.WordsNotesRepositoryFakeImpl
import com.grig.mydictionaryjet.data.repository.words.WordsRepositoryImpl
import com.grig.mydictionaryjet.domain.model.WordsNote
import com.grig.mydictionaryjet.domain.repository.WordsNotesRepository
import com.grig.mydictionaryjet.domain.repository.WordsRepository
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

    @Provides
    @Singleton
    fun provideGetWordsNotesRepository(wordsNotes: List<WordsNote>): WordsNotesRepository {
        return WordsNotesRepositoryFakeImpl(wordsNotes)
    }
}