package com.grig.mydictionaryjet.domain.use_case.get_word

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
        try {
            emit(Resource.Loading())
            val words = repository.getWords().map { it.toWord() }
            emit(Resource.Success(words))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Word>>(e.localizedMessage ?: "An unexpected error "))
        } catch (e: IOException) {
            emit(Resource.Error<List<Word>>("Couldn't reach server. Check your internet connection!"))
        }
    }
}