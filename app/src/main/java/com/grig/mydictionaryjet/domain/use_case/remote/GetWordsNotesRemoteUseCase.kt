package com.grig.mydictionaryjet.domain.use_case.remote

import com.grig.mydictionaryjet.common.Resource
import com.grig.mydictionaryjet.domain.model.WordsNote
import com.grig.mydictionaryjet.domain.repository.WordsNoteRemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWordsNotesRemoteUseCase @Inject constructor(
    private val repository: WordsNoteRemoteRepository
) {
    operator fun invoke(): Flow<Resource<List<WordsNote>>> = flow {
//        emit(Resource.Success(listOf(Word("eee", "ffffffff"))))
        repository.getWordsNotes().collect { res ->
            try {
                emit(Resource.Loading())
//                for (i in res) {
//                    Log.d("MyLog", i.engWord ?: "null")
//                }
                val words = res.map { it.toWordsNote() }
                emit(Resource.Success(words))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error "))
            } catch (e: IOException) {
                emit(Resource.Error("Couldn't reach server. Check your internet connection!"))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "An unexpected error"))
            }
        }
    }
}