package com.grig.mydictionaryjet.presentation.words_show.common.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.grig.mydictionaryjet.data.remote.talker.MediaHelper
import com.grig.mydictionaryjet.domain.model.Word
import com.grig.mydictionaryjet.presentation.words_show.common.WordsItemEvent
import kotlinx.coroutines.launch

@SuppressLint("MutableCollectionMutableState")
@Composable
fun WordsList(
    words: List<Word>,
    mediaHelper: MediaHelper? = null
//    viewModel: WordsListViewModel = hiltViewModel()
) {


//    val expandedWordIds by viewModel.expandedWordIds.collectAsState()
//    val speakingWordIds by viewModel.speakingWordIds.collectAsState()
//    val _state = remember {
//        mutableStateOf(state)
//    }
//    val expandedState = remember(words) {
//        words.map { false }.toMutableStateList()
//    }
//    val speakingState = remember(words) {
//        words.map { false }.toMutableStateList()
//    }

    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 7.dp)
                .padding(horizontal = 6.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            itemsIndexed(words) { i, word ->
                var expanded by remember {
                    mutableStateOf(
                        false
                    )
                }
                var speaking by remember {
                    mutableStateOf(
                        false
                    )
                }
                WordItem(expanded = expanded,
                    speaking = speaking,
                    word = word, onEvent = { event ->
                    when (event) {
                        is WordsItemEvent.ClickTalker -> {
                                speaking = !speaking

                                scope.launch {
                                    mediaHelper?.sayWord(
                                        word.engWord
                                    ) {
                                        speaking = false
                                    }
                                }
//                            }
                        }
                        is WordsItemEvent.ClickItem -> {
                            scope.launch {
                                expanded = !expanded
                            }
                        }
                    }
                })
            }
        }
    }
}
