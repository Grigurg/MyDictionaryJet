package com.grig.mydictionaryjet.domain.use_case.words

import com.grig.mydictionaryjet.common.Resource
import com.grig.mydictionaryjet.data.dto.toWord
import com.grig.mydictionaryjet.domain.model.Word
import com.grig.mydictionaryjet.domain.repository.WordsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWordsUseCase @Inject constructor(
    private val repository: WordsRepository
) {
    operator fun invoke(): Flow<Resource<List<Word>>> = flow {
//        emit(Resource.Success(listOf(Word("eee", "ffffffff"))))
        repository.getWords().collect { res ->
            try {
                emit(Resource.Loading())
//                for (i in res) {
//                    Log.d("MyLog", i.engWord ?: "null")
//                }
                val words = res.map { it.toWord() }
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