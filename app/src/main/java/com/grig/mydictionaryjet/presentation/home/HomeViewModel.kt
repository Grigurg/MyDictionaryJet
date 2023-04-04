package com.grig.mydictionaryjet.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grig.mydictionaryjet.domain.model.WordsNote
import com.grig.mydictionaryjet.domain.use_case.notes.GetWordsNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWordsNotesUseCase: GetWordsNotesUseCase
) : ViewModel() {

    private val _wordsNotes = MutableStateFlow(listOf<WordsNote>())
    val wordsNotes = _wordsNotes.asStateFlow()

    init {
        viewModelScope.launch {
            getWordsNotesUseCase().collect { wordsNotes ->
                _wordsNotes.emit(wordsNotes)
//                Log.d("MyLog", "tittle ${wordsNotes[1].title}")
            }
        }
    }
}