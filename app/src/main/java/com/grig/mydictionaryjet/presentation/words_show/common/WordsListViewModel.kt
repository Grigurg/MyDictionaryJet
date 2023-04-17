package com.grig.mydictionaryjet.presentation.words_show.common

//import androidx.lifecycle.ViewModel
//import com.grig.mydictionaryjet.data.remote.talker.MediaHelper
//import javax.inject.Inject
//
//class WordsListViewModel @Inject constructor(
//    private val mediaHelper: MediaHelper
//) : ViewModel() {
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
//}