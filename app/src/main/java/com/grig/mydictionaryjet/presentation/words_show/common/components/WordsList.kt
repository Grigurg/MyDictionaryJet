package com.grig.mydictionaryjet.presentation.words_show.common.components

import android.os.Build
import android.util.Log
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
import com.grig.mydictionaryjet.presentation.words_show.common.WordsItemEvent
import com.grig.mydictionaryjet.presentation.words_show.common.WordsListState
import kotlinx.coroutines.launch

@Composable
fun WordsList(
    state: WordsListState,
    mediaHelper: MediaHelper? = null
//    viewModel: WordsListViewModel = hiltViewModel()
) {

//    val expandedWordIds by viewModel.expandedWordIds.collectAsState()
//    val speakingWordIds by viewModel.speakingWordIds.collectAsState()
//    val _state = remember {
//        mutableStateOf(state)
//    }
    var expandedWordIds by remember {
        mutableStateOf(state.expandedWordIds)
    }
    var speakingWordIds by remember {
        mutableStateOf(
            state.speakingWordIds
        )
    }

    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 7.dp)
                .padding(horizontal = 6.dp), verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            itemsIndexed(state.words) { index, word ->
                Log.d("MyLog", index.toString())
                WordItem(expanded = expandedWordIds.contains(index),
                    speaking = speakingWordIds.contains(index),
                    word = word,
                    ind = index,
                    onEvent = { event ->
                        when (event) {
                            is WordsItemEvent.ClickTalker -> {
                                scope.launch {
                                    speakingWordIds = speakingWordIds.toMutableList()
                                        .also { list ->
                                            if (list.contains(event.id)) {
                                                list.remove(
                                                    event.id
                                                )
                                            } else {
                                                list.add(event.id)
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    Log.d("MyLog", "trying saying word")
                                                    scope.launch {
                                                        mediaHelper?.sayWord(onCompletion = {
                                                            speakingWordIds =
                                                                speakingWordIds.toMutableList()
                                                                    .also { it.remove(event.id) }
                                                        }, word.engWord)
                                                    }
                                                }
                                            }
                                        }
                                }
                            }
                            is WordsItemEvent.ClickItem -> {
                                scope.launch {

                                    expandedWordIds = expandedWordIds.toMutableList()
                                        .also { list ->
                                            if (list.contains(event.id)) list.remove(
                                                event.id
                                            )
                                            else list.add(event.id)
                                        }
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}
