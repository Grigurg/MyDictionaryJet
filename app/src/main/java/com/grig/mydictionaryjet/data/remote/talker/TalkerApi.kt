package com.grig.mydictionaryjet.data.remote.talker

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Streaming
import retrofit2.http.Body

interface TalkerApi {
//    @Streaming
    @GET("/{word}.mp3")
    suspend fun getAudio(@Path("word") word: String ) : Response<ResponseBody>
}