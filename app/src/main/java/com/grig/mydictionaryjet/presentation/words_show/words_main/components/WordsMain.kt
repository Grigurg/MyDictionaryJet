package com.grig.mydictionaryjet.presentation.words_show.words_main.components

//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material.CircularProgressIndicator
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.hilt.navigation.compose.hiltViewModel
//import com.grig.mydictionaryjet.presentation.words_show.common.components.WordsList
//import com.grig.mydictionaryjet.presentation.words_show.words_main.WordsMainViewModel
//
//@Composable
//fun WordsMain(
//    viewModel: WordsMainViewModel = hiltViewModel()
////    viewModel: WordsMainViewModel = androidx.lifecycle.viewmodel.compose.viewModel(modelClass = WordsMainViewModel::class.java)
//) {
//
////    val expandedWordIds by viewModel.expandedWordIds.collectAsState()
////    val speakingWordIds by viewModel.speakingWordIds.collectAsState()
////    val viewModel: WordsMainViewModel by viewModel
//    val state by viewModel.state.collectAsState()
//    val wordsListState = state.wordsListState
//
//    Box(modifier = Modifier.fillMaxSize()) {
//        WordsList(state = wordsListState, mediaHelper = viewModel.mediaHelper)
//
//        if (state.error.isNotBlank()) {
//            Text(
//                text = state.error,
//                color = MaterialTheme.colors.error,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 20.dp)
//                    .align(Alignment.Center)
//            )
//        }
//        if (state.isLoading) {
//            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
//        }
//    }
//}