package com.grig.mydictionaryjet.presentation
//
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.pager.HorizontalPager
//import androidx.compose.foundation.pager.rememberPagerState
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Modifier
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.grig.mydictionaryjet.presentation.home.HomeViewModel
//import com.grig.mydictionaryjet.presentation.home.components.HomeScreen
//import com.grig.mydictionaryjet.presentation.words_show.WordsListViewModel
//import com.grig.mydictionaryjet.presentation.words_show.components.WordsList
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.coroutineScope
//import kotlinx.coroutines.launch

//@OptIn(ExperimentalFoundationApi::class)
//@Composable
// fun Pager() {
//    val wordsListViewModel = viewModel(modelClass = WordsListViewModel::class.java)
//    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
//    val scope = rememberCoroutineScope()
//
//    HorizontalPager(pageCount = 2, state = rememberPagerState(initialPage = 0)) {page ->
//        Box(modifier = Modifier.fillMaxSize()) {
//            when (page) {
//                0 -> HomeScreen(viewModel = homeViewModel)
//                1 -> WordsList(viewModel = wordsListViewModel)
//            }
//        }
//    }
//}