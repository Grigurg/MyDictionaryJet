package com.grig.mydictionaryjet.presentation.words_show.remote_words

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grig.mydictionaryjet.data.remote.talker.MediaHelper
import com.grig.mydictionaryjet.domain.use_case.remote.GetRemoteWordsNote
import com.grig.mydictionaryjet.presentation.words_show.common.WordsListState
import com.grig.mydictionaryjet.presentation.words_show.words_note.WordsNoteState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RemoteWordsNoteViewModel @Inject constructor(
    private val getWordsNoteUseCase: GetRemoteWordsNote,
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
            getWordsNoteUseCase(title).collect { wordsNote ->
                _state.emit(
                    WordsNoteState(
                        title = wordsNote.title,
                        wordsListState = WordsListState(
                            words = com.grig.mydictionaryjet.domain.model.WordsNote.wordsFromString(
                                wordsNote.content
                            )
                        )
//                useCases.getWordsNote(title)
                    )
                )
            }
        }
    }
}