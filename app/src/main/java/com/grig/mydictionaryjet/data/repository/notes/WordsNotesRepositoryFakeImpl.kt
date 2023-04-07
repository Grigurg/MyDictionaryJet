//package com.grig.mydictionaryjet.data.repository.notes
//
//import com.grig.mydictionaryjet.domain.model.Word
//import com.grig.mydictionaryjet.domain.model.WordsNote
//import com.grig.mydictionaryjet.domain.repository.WordsNotesRepository
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//import javax.inject.Inject
//
//class WordsNotesRepositoryFakeImpl : WordsNotesRepository {
//
////    companion object {
////        val wordsNotes = listOf(
////            WordsNote(
////                "Words from TT", listOf(
////                    Word("take up", "занимать"),
////                    Word("poison", "яд"),
////                    Word("trait", "черта")
////                )
////            ),
////            WordsNote(
////                "Words from books",
////                listOf(
////                    Word("insult", "оскорблять"),
////                    Word("avenge", "мстить"),
////                    Word("punish", "наказывать"),
////                    Word("military", "военный"),
////                    Word("capture", "захват")
////                )
////            ),
////            WordsNote(
////                "Words from songs",
////                listOf(
////                    Word("give in", "поддаваться"),
////                    Word("sip", "глоток"),
////                    Word("thrifty", "бережлиывй")
////                )
////            )
////        )
////    }
//
//    override suspend fun getWordsNotes(): Flow<List<WordsNote>> = flow {
//        emit(wordsNotes)
//    }
//
//    override suspend fun getWordsNoteByTitle(title: String): WordsNote {
//        return when (title) {
//            "Words from TT" -> wordsNotes[0]
//            "Words from books" -> wordsNotes[1]
//            "Words from songs" -> wordsNotes[2]
//            else -> wordsNotes[0]
//        }
//    }
//
//    override suspend fun insertWordsNote(wordsNote: WordsNote) {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun deleteWordsNote(wordsNote: WordsNote) {
//        TODO("Not yet implemented")
//    }
//}