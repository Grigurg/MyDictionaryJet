package com.grig.mydictionaryjet.domain.use_case.remote

import android.util.Log
import com.grig.mydictionaryjet.domain.model.WordsNote
import com.grig.mydictionaryjet.domain.repository.WordsNoteRemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetRemoteWordsNote @Inject constructor(
    private val repository: WordsNoteRemoteRepository
) {
    operator fun invoke(title: String): Flow<WordsNote> = flow {
        Log.d("MyLog", "get remote ues case $")
//        emit(Resource.Success(listOf(Word("eee", "ffffffff"))))
        repository.getWordsNote(title).collect { wordsNote ->
            Log.d("MyLog", "get remote ues case ${wordsNote.title}")
//                for (i in res) {
//                    Log.d("MyLog",  i.toWordsNote().content
//                        ?: "null")
//                }
//                Log.d("MyLog", res.map { it.toWordsNote() })
            emit(wordsNote.toWordsNote())

        }
    }
}