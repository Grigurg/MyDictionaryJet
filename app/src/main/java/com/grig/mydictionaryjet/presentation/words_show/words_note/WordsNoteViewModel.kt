package com.grig.mydictionaryjet.presentation.words_show.words_note

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grig.mydictionaryjet.data.remote.talker.MediaHelper
import com.grig.mydictionaryjet.domain.model.WordsNote
import com.grig.mydictionaryjet.domain.use_case.database.WordsNotesUseCases
import com.grig.mydictionaryjet.presentation.words_show.common.WordsListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordsNoteViewModel @Inject constructor(
    private val useCases: WordsNotesUseCases,
    val mediaHelper: MediaHelper,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(WordsNoteState())
    val state = _state.asStateFlow()

    init {
        savedStateHandle.get<String>("title")?.let { title ->
            getWordsNote(title)
        }
    }

    private fun getWordsNote(title: String) {
        viewModelScope.launch {
            val wordsNote = useCases.getWordsNote(title)
            _state.emit(
                WordsNoteState(
                    title = wordsNote.title,
                    wordsListState = WordsListState(words = WordsNote.wordsFromString(wordsNote.content))
//                useCases.getWordsNote(title)
                )
            )
        }
    }
}