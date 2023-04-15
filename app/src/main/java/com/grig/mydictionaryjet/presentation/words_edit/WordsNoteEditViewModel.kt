package com.grig.mydictionaryjet.presentation.words_edit

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grig.mydictionaryjet.domain.model.WordsNote
import com.grig.mydictionaryjet.domain.use_case.database.WordsNotesUseCases
import com.grig.mydictionaryjet.presentation.words_edit.components.WordsNoteEditEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordsNoteEditViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val useCases: WordsNotesUseCases,
//    private val typeConverters: WordsTypeConverters
): ViewModel() {
//    private val _wordsNote = MutableStateFlow(WordsNote())
//    val wordsNote = _wordsNote.asStateFlow()

    private val _title = MutableStateFlow(String())
    val title = _title.asStateFlow()

    private val _content = MutableStateFlow(String())
    val content = _content.asStateFlow()

    init {
        val title = savedStateHandle.get<String>("title")
        viewModelScope.launch {
            if (title != null) {
                val note = useCases.getWordsNote(title)
                val content = note.content
                _title.emit(note.title)
                _content.emit(content)
            }
        }
    }

    fun onEvent(event: WordsNoteEditEvent) {
        when (event) {
            is WordsNoteEditEvent.TitleChanged -> {
                viewModelScope.launch {
                    _title.emit(event.title)
                }
            }
            is WordsNoteEditEvent.ContentChanged -> {
                viewModelScope.launch {
                    _content.emit(event.content)
                }
            }
            is WordsNoteEditEvent.Save -> {
                viewModelScope.launch {
                    useCases.insertWordsNote(
                        WordsNote(
                            title = title.value,
                            content = content.value
                        )
                    )

                }
            }
        }
    }


//    init {
//        val title = savedStateHandle.get<String>("title")
//        viewModelScope.launch {
//            val note = useCases.getWordsNote(title ?: "")
//            _wordsNote.emit(note)
//        }
//    }л
//
//    fun onEvent(event: WordsNoteEditEvent) {
//        when (event) {
//            is WordsNoteEditEvent.TitleChanged -> {
//                viewModelScope.launch {
//                    _wordsNote.emit(wordsNote.value.copy(title = event.title))
//                }
//            }
//            is WordsNoteEditEvent.ContentChanged -> {
//                viewModelScope.launch {
//                    _wordsNote.emit(wordsNote.value.copy(wo))
//                }
//            }
//        }
//    }
}