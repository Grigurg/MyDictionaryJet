package com.grig.mydictionaryjet.presentation.words_show

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grig.mydictionaryjet.common.Resource
import com.grig.mydictionaryjet.domain.use_case.words.GetWordsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordsListViewModel @Inject constructor(
    private val getWordsUseCase: GetWordsUseCase
) : ViewModel() {

//    private val _state: MutableStateFlow<WordsListState> = MutableStateFlow(WordsListState())
//    val state: StateFlow<WordsListState> get() = _state

//    private val _words = MutableStateFlow(listOf<Word>())
//    val words: StateFlow<List<Word>> get() = _words

    private val _state = MutableStateFlow(WordsListState())
    val state: StateFlow<WordsListState> get() = _state

//    private val _speakingWordIds = MutableStateFlow(listOf<Int>())
//    val speakingWordIds: StateFlow<List<Int>> get() = _speakingWordIds
//
//    private val _expandedWordIds = MutableStateFlow(listOf<Int>())
//    val expandedWordIds: StateFlow<List<Int>> get() = _expandedWordIds

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
//        viewModelScope.launch {
//            _state.emit(WordsListState(words = listOf(Word("kettle", "Чайник"))))
//        }
        viewModelScope.launch {
            getWordsUseCase().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.emit(
                            WordsListState(
                                words = result.data
                                    ?: emptyList()
                            )
                        )
                    }
                    is Resource.Error -> {
                        _state.emit(WordsListState(error = result.message ?: "An unexpected error"))
                    }
                    is Resource.Loading -> {
                        _state.emit(WordsListState(isLoading = true))
                    }
                }
            }
        }
//        }.launchIn(viewModelScope)
    }

    fun onEvent(event: WordsItemEvent) {
        when (event) {
            is WordsItemEvent.ClickTalker -> {
                viewModelScope.launch {
                    _state.emit(_state.value.copy(speakingWordIds = _state.value.speakingWordIds))
                }
            }
            is WordsItemEvent.ClickItem -> {
                viewModelScope.launch {
                    _state.emit(
                        _state.value.copy(
                            expandedWordIds = _state.value.expandedWordIds.toMutableList()
                                .also { list ->
                                    if (list.contains(event.id)) list.remove(event.id)
                                    else list.add(event.id)
                                })
                    )
                }
            }
        }
    }

//    fun onEvent(event: WordsItemEvent) {
//        when (event) {
//            is WordsItemEvent.ClickTalker -> {
//                _speakingWordIds.value = speakingWordIds.value.toMutableList().also { list ->
//                    if (list.contains(event.id)) list.remove(event.id)
//                    else list.add(event.id)
//                }
//            }
//            is WordsItemEvent.ClickItem -> {
//                _expandedWordIds.value = expandedWordIds.value.toMutableList().also { list ->
//                    if (list.contains(event.id)) list.remove(event.id)
//                    else list.add(event.id)
//                }
//            }
//        }
//    }
}