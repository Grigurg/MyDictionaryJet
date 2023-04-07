package com.grig.mydictionaryjet.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grig.mydictionaryjet.domain.model.Word
import com.grig.mydictionaryjet.domain.model.WordsNote
import com.grig.mydictionaryjet.domain.use_case.notes.WordsNotesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: WordsNotesUseCases
) : ViewModel() {

    private val _wordsNotes = MutableStateFlow(listOf<WordsNote>())
    val wordsNotes = _wordsNotes.asStateFlow()

    init {
        for (wordsNote in  listOf(
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
        )) {
//            for (i in 0..3) {
//                viewModelScope.launch {
//                    useCases.deleteWordsNote(wordsNote)
//                }
//            }
            viewModelScope.launch {
                useCases.insertWordsNote(wordsNote)
            }
        }
        viewModelScope.launch {
            useCases.getWordsNotes().collect { wordsNotes ->
                _wordsNotes.emit(wordsNotes)
//                Log.d("MyLog", "tittle ${wordsNotes[1].title}")
            }
        }
    }
}