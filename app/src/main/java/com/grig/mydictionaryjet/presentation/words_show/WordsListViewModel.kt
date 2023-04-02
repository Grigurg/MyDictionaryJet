package com.grig.mydictionaryjet.presentation.words_show

import androidx.lifecycle.ViewModel
import com.grig.mydictionaryjet.common.Resource
import com.grig.mydictionaryjet.domain.use_case.get_word.GetWordsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WordsListViewModel @Inject constructor(
    private val getWordsUseCase: GetWordsUseCase
) : ViewModel() {

//    private val _state: MutableStateFlow<WordsListState> = MutableStateFlow(WordsListState())
//    val state: StateFlow<WordsListState> get() = _state

//    private val _words = MutableStateFlow(listOf<Word>())
//    val words: StateFlow<List<Word>> get() = _words

    private val _words = MutableStateFlow(WordsListState())
    val words: StateFlow<WordsListState> get() = _words

    private val _speakingWordIds = MutableStateFlow(listOf<Int>())
    val speakingWordIds: StateFlow<List<Int>> get() = _speakingWordIds

    private val _expandedWordIds = MutableStateFlow(listOf<Int>())
    val expandedWordIds: StateFlow<List<Int>> get() = _expandedWordIds

    init {
        getWords()
    }

//    private fun getWords() {
//        getWordsUseCase().onEach { result ->
//            when (result) {
//                is Resource.Success -> {
//                    _state.emit(WordsListState(words = result.data
//                        ?: emptyList()))
//                }
//                is Resource.Error -> {
//                    _state.emit(WordsListState(error = result.message ?: "An unexpected error"))
//                }
//                is Resource.Loading -> {
//                    _state.emit(WordsListState(isLoading = true))
//                }
//            }
//        }
//    }
//
//    fun onEvent(event: WordsItemEvent) {
//        when (event) {
//            is WordsItemEvent.ClickTalker -> {
//                _state.value = state.value.copy(
//                    expandedWordIds = state.value.expandedWordIds.toMutableList().also { list ->
//                        if (list.contains(event.id)) list.remove(event.id)
//                        else list.add(event.id)
//                    })
//            }
//            is WordsItemEvent.ClickItem -> {
//                _state.value = state.value.copy(
//                    speakingWordIds = state.value.speakingWordIds.toMutableList().also { list ->
//                        if (list.contains(event.id)) list.remove(event.id)
//                        else list.add(event.id)
//                    })
//            }
//        }
//    }

        private fun getWords() {
        getWordsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _words.emit(WordsListState(words = result.data
                        ?: emptyList()))
                }
                is Resource.Error -> {
                    _words.emit(WordsListState(error = result.message ?: "An unexpected error"))
                }
                is Resource.Loading -> {
                    _words.emit(WordsListState(isLoading = true))
                }
            }
        }
    }

    fun onEvent(event: WordsItemEvent) {
        when (event) {
            is WordsItemEvent.ClickTalker -> {
                _speakingWordIds.value = speakingWordIds.value.toMutableList().also { list ->
                    if (list.contains(event.id)) list.remove(event.id)
                    else list.add(event.id)
                }
            }
            is WordsItemEvent.ClickItem -> {
                _expandedWordIds.value = expandedWordIds.value.toMutableList().also { list ->
                    if (list.contains(event.id)) list.remove(event.id)
                    else list.add(event.id)
                }
            }
        }
    }
}