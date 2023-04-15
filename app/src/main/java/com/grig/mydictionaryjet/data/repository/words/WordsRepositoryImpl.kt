package com.grig.mydictionaryjet.data.repository.words

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.grig.mydictionaryjet.data.dto.WordDto
import com.grig.mydictionaryjet.domain.repository.WordsRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import javax.inject.Inject

class WordsRepositoryImpl @Inject constructor(
    private val ref: DatabaseReference
) : WordsRepository {
    @OptIn(DelicateCoroutinesApi::class)
    override suspend fun getWords(): Flow<List<WordDto>> = channelFlow {

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val words = mutableListOf<WordDto>()


                for (word in snapshot.children) {
                    words.add(word.getValue(WordDto::class.java)!!)
                }
                launch {
                    send(words)
                    cancel()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("MyLog", error.message)
            }

        })
        awaitCancellation()
//        delay(2000)
//        launch {
//            send(listOf(WordDto("eehee", "gghjgkhjg78")))
//        }
    }
}