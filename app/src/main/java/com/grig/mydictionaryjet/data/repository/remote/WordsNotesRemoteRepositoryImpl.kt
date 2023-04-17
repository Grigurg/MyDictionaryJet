package com.grig.mydictionaryjet.data.repository.remote

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.grig.mydictionaryjet.domain.repository.WordsNotesRemoteRepository
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class WordsNotesRemoteRepositoryImpl @Inject constructor(
    private val db: FirebaseDatabase
) : WordsNotesRemoteRepository {
    override suspend fun getWordsNotesTitles(): Flow<List<String>> = channelFlow {
        val ref = db.getReference("words")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val titles = mutableListOf<String>()
                for (title in snapshot.children) {
                    titles.add(title.key.toString())
                }

                launch {
                    send(titles)
                }

//                for (wordsNote in snapshot.children) {
//                    val words = mutableListOf<WordDto>()
//                    for (word in wordsNote.children) {
//                        words.add(word.getValue(WordDto::class.java)!!)
//                    }
//                    wordsNotes.add(WordsNoteDto(title = wordsNote.key.toString(), words = words))
////                    Log.d("MyLog", wordsNote.key .toString())
//                }
//                launch {
//                    send(listOf(snapshot.children.map { it.getValue(String::class.java) }))
//                }
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