package com.grig.mydictionaryjet.data.repository

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.grig.mydictionaryjet.BuildConfig
import java.util.concurrent.CompletableFuture
import javax.inject.Inject

class VersionControl @Inject constructor(
    private val db: FirebaseDatabase
) {
    private fun getVersion(): CompletableFuture<Int> {
        val ref = db.getReference("version")
        val future = CompletableFuture<Int>()

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val version: Int = snapshot.getValue(Int::class.java) ?: -1
                future.complete(version)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("MyLog", error.message)
            }
        })

        return future
    }

    fun isVersionLatest(): CompletableFuture<Boolean> {
        val future = CompletableFuture<Boolean>()
        getVersion().thenAccept { version ->
            Log.d("MyLog", "Version is $version buikd is ${BuildConfig.VERSION_CODE}")
            if (BuildConfig.VERSION_CODE > version) {
                Log.d("MyLog", "throw ")
                throw NotLatestVersionInDatabase(" jkljlk j")
            }
            future.complete((BuildConfig.VERSION_CODE == version))
        }
        return future
    }
}

class NotLatestVersionInDatabase(msg: String): Exception(msg)
