package com.grig.mydictionaryjet.presentation.words_edit.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.grig.mydictionaryjet.presentation.words_edit.WordsNoteEditViewModel

@Composable
fun WordsNoteEdit(
    viewModel: WordsNoteEditViewModel = hiltViewModel()
) {
    val wordsNote by viewModel.wordsNote.collectAsState()
    TextField(value = wordsNote.title, onValueChange = {
        viewModel.onEvent(WordsNoteEditEvent.TitleChanged(it))
    }
    )
//    val wordsNote by viewModel.wordsNote.collectAsState()
//    var title by remember {
//    mutableStateOf(wordsNote.title)
//}
////    var title by remember {
////        mutableStateOf(wordsNote.title)
////    }
//    var content by remember {
//        mutableStateOf(wordsNote.words.toString())
//    }
//
//    Column(Modifier.fillMaxSize()) {
//        TextField(value = title, onValueChange = {
//            Log.d("MyLog", "it is $it")
//            title = it
//        })
//        TransparentTextFiled(value = wordsNote.title, onValueChange = { })
//    }
}