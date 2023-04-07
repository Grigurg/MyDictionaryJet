package com.grig.mydictionaryjet.data.remote.talker

import retrofit2.Retrofit

//import retrofit2.converter.gson.

object RetrofitClient {
    private const val baseUrl = "https://d1qx7pbj0dvboc.cloudfront.net/"

    fun getInstance(): Retrofit =
        Retrofit.Builder().baseUrl(baseUrl).build()
}