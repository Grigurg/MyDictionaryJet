package com.grig.mydictionaryjet.presentation.words_show.words_main

//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.grig.mydictionaryjet.common.Resource
//import com.grig.mydictionaryjet.data.remote.talker.MediaHelper
//import com.grig.mydictionaryjet.domain.model.WordsNote
//import com.grig.mydictionaryjet.domain.use_case.remote.`GetWordsNotesRemote\`
//import com.grig.mydictionaryjet.presentation.words_show.common.WordsListState
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class WordsMainViewModel @Inject constructor(
//    private val getWordsUseCase: `GetWordsNotesRemote\`,
//    val mediaHelper: MediaHelper
//) : ViewModel() {
//
////    private val _state: MutableStateFlow<WordsListState> = MutableStateFlow(WordsListState())
////    val state: StateFlow<WordsListState> get() = _state
//
////    private val _words = MutableStateFlow(listOf<Word>())
////    val words: StateFlow<List<Word>> get() = _words
//
//    private val _state = MutableStateFlow(WordsMainState())
//    val state: StateFlow<WordsMainState> get() = _state
//
////    private val _speakingWordIds = MutableStateFlow(listOf<Int>())
////    val speakingWordIds: StateFlow<List<Int>> get() = _speakingWordIds
////
////    private val _expandedWordIds = MutableStateFlow(listOf<Int>())
////    val expandedWordIds: StateFlow<List<Int>> get() = _expandedWordIds
//
//    init {
//        getWords()
//    }
//
////    private fun getWords() {
////        getWordsUseCase().onEach { result ->
////            when (result) {
////                is Resource.Success -> {
////                    _state.emit(WordsListState(words = result.data
////                        ?: emptyList()))
////                }
////                is Resource.Error -> {
////                    _state.emit(WordsListState(error = result.message ?: "An unexpected error"))
////                }
////                is Resource.Loading -> {
////                    _state.emit(WordsListState(isLoading = true))
////                }
////            }
////        }
////    }
////
////    fun onEvent(event: WordsItemEvent) {
////        when (event) {
////            is WordsItemEvent.ClickTalker -> {
////                _state.value = state.value.copy(
////                    expandedWordIds = state.value.expandedWordIds.toMutableList().also { list ->
////                        if (list.contains(event.id)) list.remove(event.id)
////                        else list.add(event.id)
////                    })
////            }
////            is WordsItemEvent.ClickItem -> {
////                _state.value = state.value.copy(
////                    speakingWordIds = state.value.speakingWordIds.toMutableList().also { list ->
////                        if (list.contains(event.id)) list.remove(event.id)
////                        else list.add(event.id)
////                    })
////            }
////        }
////    }
//
//    private fun getWords() {
////        viewModelScope.launch {
////            _state.emit(WordsListState(words = listOf(Word("kettle", "Чайник"))))
////        }
//        viewModelScope.launch {
//            getWordsUseCase().collect { result ->
////                Log.d("MyLog", ("get" + result.data?.getOrNull(0)?.title) ?: "Null title")
//                when (result) {
//                    is Resource.Success -> {
//                        _state.emit(
//                            WordsMainState(
//                                wordsListState =
//                                WordsListState(
//                                    words = WordsNote.wordsFromString(result.data?.get(0)?.content ?: "")
//                                )
//                            )
//                        )
//                    }
//                    is Resource.Error -> {
//                        _state.emit(
//                            WordsMainState(
//                                error = result.message ?: "An unexpected error"
//                            )
//                        )
//                    }
//                    is Resource.Loading -> {
//                        _state.emit(WordsMainState(isLoading = true))
//                    }
//                }
//            }
//        }
////        }.launchIn(viewModelScope)
//    }
//
////    fun onEvent(event: WordsItemEvent) {
////        when (event) {
////            is WordsItemEvent.ClickTalker -> {
////                viewModelScope.launch {
////                    _state.emit(
////                        _state.value.copy(
////                            wordsListState = _state.value.wordsListState.copy(
////                                speakingWordIds = _state.value.wordsListState.speakingWordIds.toMutableList()
////                                    .also { list ->
////                                        if (list.contains(event.id)) list.remove(event.id)
////                                        else list.add(event.id)
////                                    }
////                            )
////                        )
////                    )
////                }
////            }
////            is WordsItemEvent.ClickItem -> {
////                viewModelScope.launch {
////                    _state.emit(
////                        _state.value.copy(
////                            wordsListState = _state.value.wordsListState.copy(
////                                speakingWordIds = _state.value.wordsListState.expandedWordIds.toMutableList()
////                                    .also { list ->
////                                        if (list.contains(event.id)) list.remove(event.id)
////                                        else list.add(event.id)
////                                    }
////                            )
////                        )
////                    )
////                }
////            }
////        }
////    }
//
////    fun onEvent(event: WordsItemEvent) {
////        when (event) {
////            is WordsItemEvent.ClickTalker -> {
////                _speakingWordIds.value = speakingWordIds.value.toMutableList().also { list ->
////                    if (list.contains(event.id)) list.remove(event.id)
////                    else list.add(event.id)
////                }
////            }
////            is WordsItemEvent.ClickItem -> {
////                _expandedWordIds.value = expandedWordIds.value.toMutableList().also { list ->
////                    if (list.contains(event.id)) list.remove(event.id)
////                    else list.add(event.id)
////                }
////            }
////        }
////    }
//}