package com.grig.mydictionaryjet.di

import com.grig.mydictionaryjet.data.repository.WordsRepositoryFakeImpl
import com.grig.mydictionaryjet.domain.repository.WordsRepository
import com.grig.mydictionaryjet.domain.use_case.get_word.GetWordsUseCase
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
    fun provideWordsRepository(): WordsRepository {
        return WordsRepositoryFakeImpl()
    }

    @Provides
    @Singleton
    fun provideGetWordsUseCase(repository: WordsRepository): GetWordsUseCase {
        return GetWordsUseCase(repository)
    }
}