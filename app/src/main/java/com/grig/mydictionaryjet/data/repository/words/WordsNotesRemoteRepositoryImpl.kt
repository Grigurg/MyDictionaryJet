package com.grig.mydictionaryjet.data.repository.words

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.grig.mydictionaryjet.data.dto.WordDto
import com.grig.mydictionaryjet.data.dto.WordsNoteDto
import com.grig.mydictionaryjet.domain.repository.WordsNotesRemoteRepository
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class WordsNotesRemoteRepositoryImpl @Inject constructor(
    private val db: FirebaseDatabase
) : WordsNotesRemoteRepository {
    override suspend fun getWordsNotes(): Flow<List<WordsNoteDto>> = channelFlow {
        val ref = db.getReference("words")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val wordsNotes = mutableListOf<WordsNoteDto>()

                for (wordsNote in snapshot.children) {
                    val words = mutableListOf<WordDto>()
                    for (word in wordsNote.children) {
                        words.add(word.getValue(WordDto::class.java)!!)
                    }
                    wordsNotes.add(WordsNoteDto(title = wordsNote.key.toString(), words = words))
//                    Log.d("MyLog", wordsNote.key .toString())
                }
                launch {
                    send(wordsNotes)
                }
//                for (word in snapshot.children) {
//                    words.add(word.getValue(WordDto::class.java)!!)
//                }
//                launch {
//                    send(words)
//                    cancel()
//                }
//                for (wordsNote in wordsNotes) {
//                    Log.d("MyLog", wordsNote.title + WordsNote.wordsToString(wordsNote.words?.map { it.toWord() } ?: emptyList()))
//                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("MyLog", error.message)
            }

        })
        awaitCancellation()
    }
}