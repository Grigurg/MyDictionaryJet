package com.grig.mydictionaryjet.domain.use_case.remote

import com.grig.mydictionaryjet.domain.repository.WordsNotesRemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

//class GetRemoteWordsNotes @Inject constructor(
//    private val repository: WordsNoteRemoteRepository
//) {
//    operator fun invoke(): Flow<Resource<List<WordsNote>>> = flow {
////        emit(Resource.Success(listOf(Word("eee", "ffffffff"))))
//        repository.getWordsNotes().collect { res ->
//            try {
//                Log.d("MyLog", "receive data in getRemoteWordsNotesUseCase")
//                emit(Resource.Loading())
////                for (i in res) {
////                    Log.d("MyLog",  i.toWordsNote().content
////                        ?: "null")
////                }
////                Log.d("MyLog", res.map { it.toWordsNote() })
//                val words = res.map { it.toWordsNote() }
//                emit(Resource.Success(words))
//            } catch (e: HttpException) {
//                emit(Resource.Error(e.localizedMessage ?: "An unexpected error "))
//            } catch (e: IOException) {
//                emit(Resource.Error("Couldn't reach server. Check your internet connection!"))
//            } catch (e: Exception) {
//                emit(Resource.Error(e.message ?: "An unexpected error"))
//            }
//        }
//    }
//}

class GetRemoteWordsNotes @Inject constructor(
    private val repository: WordsNotesRemoteRepository
) {
    operator fun invoke(): Flow<List<String>> = flow {
        repository.getWordsNotesTitles().collect { titles ->
            emit(titles)

        }
    }
}