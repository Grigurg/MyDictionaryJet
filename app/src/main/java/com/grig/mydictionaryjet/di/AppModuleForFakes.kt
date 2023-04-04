package com.grig.mydictionaryjet.di

import com.grig.mydictionaryjet.domain.model.Word
import com.grig.mydictionaryjet.domain.model.WordsNote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModuleForFakes {

    @Provides
    @Singleton
    fun provideWordsNotes(): List<WordsNote> {
        return listOf(
            WordsNote(
                "Words from TT", listOf(
                    Word("take up", "занимать"),
                    Word("poison", "яд"),
                    Word("trait", "черта")
                )
            ),
            WordsNote(
                "Words from books",
                listOf(
                    Word("insult", "оскорблять"),
                    Word("avenge", "мстить"),
                    Word("punish", "наказывать"),
                    Word("military", "военный"),
                    Word("capture", "захват")
                )
            ),
            WordsNote(
                "Words from songs",
                listOf(
                    Word("give in", "поддаваться"),
                    Word("sip", "глоток"),
                    Word("thrifty", "бережлиывй")
                )
            )
        )
    }
}