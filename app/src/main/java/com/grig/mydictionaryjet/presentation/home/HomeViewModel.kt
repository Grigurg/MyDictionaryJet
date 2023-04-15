package com.grig.mydictionaryjet.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grig.mydictionaryjet.domain.model.WordsNote
import com.grig.mydictionaryjet.domain.use_case.database.WordsNotesUseCases
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
        viewModelScope.launch {
            useCases.getWordsNotes().collect { wordsNotes ->
                _wordsNotes.emit(wordsNotes)
//                Log.d("MyLog", "tittle ${wordsNotes[1].title}")
            }
        }
    }
    fun deleteWordsNote(wordsNote: WordsNote) {
        viewModelScope.launch {
            useCases.deleteWordsNote(wordsNote)
        }
    }

//    fun addWordsNote(wordsNote: WordsNote) {
//        viewModelScope.launch {
//            useCases.insertWordsNote(wordsNote)
//        }
//    }
}