package com.grig.mydictionaryjet.presentation.words_edit.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.grig.mydictionaryjet.presentation.words_edit.WordsNoteEditViewModel

@Composable
fun WordsNoteEdit(
    viewModel: WordsNoteEditViewModel = hiltViewModel()
) {
//    val wordsNote by viewModel.wordsNote.collectAsState()
    val title by viewModel.title.collectAsState()
    val content by viewModel.content.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
//            .verticalScroll(
//                rememberScrollState()
//            )
        ,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(WordsNoteEditEvent.Save)
            }, backgroundColor = MaterialTheme.colors.surface) {
                Icon(imageVector = Icons.Default.Save, contentDescription = "Save note")
            }
        }) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
//            .background(test)
        ) {
//        BasicTextField(value = title, onValueChange = {
//            viewModel.onEvent(WordsNoteEditEvent.TitleChanged(it))
//        })
            item {
                TransparentTextFiled(
                    value = title,
                    hint = "Title",
                    textStyle = MaterialTheme.typography.h6,
                    onValueChange = {
                        viewModel.onEvent(WordsNoteEditEvent.TitleChanged(it))
                    })
            }
            item {
                TransparentTextFiled(
                    value = content,
                    hint = "Content",
                    textStyle = MaterialTheme.typography.body1,
                    onValueChange = {
                        viewModel.onEvent(WordsNoteEditEvent.ContentChanged(it))
                    })
            }
        }
    }
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