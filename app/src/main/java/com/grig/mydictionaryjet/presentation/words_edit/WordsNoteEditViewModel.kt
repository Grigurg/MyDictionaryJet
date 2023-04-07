package com.grig.mydictionaryjet.presentation.words_edit

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grig.mydictionaryjet.domain.model.WordsNote
import com.grig.mydictionaryjet.domain.use_case.notes.WordsNotesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordsNoteEditViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    useCases: WordsNotesUseCases
): ViewModel() {

    private val _wordsNote = MutableStateFlow(WordsNote())
    val wordsNote = _wordsNote.asStateFlow()

    init {
        val title = savedStateHandle.get<String>("title")
        viewModelScope.launch {
            val note = useCases.getWordsNote(title ?: "")
            _wordsNote.emit(note)
        }
    }
}