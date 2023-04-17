package com.grig.mydictionaryjet.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grig.mydictionaryjet.domain.model.WordsNote
import com.grig.mydictionaryjet.domain.use_case.database.WordsNotesUseCases
import com.grig.mydictionaryjet.domain.use_case.remote.GetRemoteWordsNotes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val wordsNotesUseCases: WordsNotesUseCases,
    private val remoteWordsNotesUseCase: GetRemoteWordsNotes
) : ViewModel() {

    private val _wordsNotes = MutableStateFlow(listOf<WordsNote>())
    val wordsNotes = _wordsNotes.asStateFlow()

    private val _remoteTitles = MutableStateFlow(listOf<String>())
    val remoteTitles = _remoteTitles.asStateFlow()

    init {
        viewModelScope.launch {
            wordsNotesUseCases.getWordsNotes().collect { wordsNotes ->
                _wordsNotes.emit(wordsNotes)
            }
        }
        viewModelScope.launch {
            remoteWordsNotesUseCase().collect { titles ->
                _remoteTitles.emit(titles)
            }
        }
    }

    fun deleteWordsNote(wordsNote: WordsNote) {
        viewModelScope.launch {
            wordsNotesUseCases.deleteWordsNote(wordsNote)
        }
    }

//    fun addWordsNote(wordsNote: WordsNote) {
//        viewModelScope.launch {
//            useCases.insertWordsNote(wordsNote)
//        }
//    }
}