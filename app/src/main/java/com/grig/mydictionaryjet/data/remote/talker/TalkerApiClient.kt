package com.grig.mydictionaryjet.data.remote.talker

import android.os.StrictMode
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import java.util.zip.GZIPInputStream

class TalkerApiClient {
    private fun getUrlMp3(word: String): String {
        val url = URL("https://ttsmp3.com/makemp3_new.php")
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "POST"
        conn.doOutput = true
        val writer = OutputStreamWriter(conn.outputStream)
        writer.write("lang=Salli&source=ttsmp3&msg=$word")
        writer.flush()
        writer.close()
        conn.outputStream.close()
        var responseStream =
            if (conn.responseCode / 100 == 2) conn.inputStream else conn.errorStream
        if ("gzip" == conn.contentEncoding) {
            responseStream = GZIPInputStream(responseStream)
        }
        val s = Scanner(responseStream).useDelimiter("\\A")
        val response = if (s.hasNext()) s.next() else ""
        val mainObject = JSONObject(response)
        return mainObject.getString("URL")
    }

//    private fun getUrlMp3(word: String): String {
//        val urlBuilder = HttpUrl.parse("https://ttsmp3.com/makemp3_new.php")?.newBuilder()
//        urlBuilder!!.addQueryParameter("msg", "word")
//        urlBuilder.addQueryParameter("lang", "Salli")
//        urlBuilder.addQueryParameter("source", "ttsmp3")
//
////        Log.d("MyLog", urlBuilder.)
//
//        val url = urlBuilder.build().toString()
//
//        val request = Request.Builder().url(url).build()
//        val response = OkHttpClient().newCall(request).execute()
//
//        Log.d("MyLog", "BODY IS ${response.body()?.string()}")
//
//        return JSONObject(response.body()?.string() ?: throw Exception("Null response body. TalkerApiClient")).getString("URl")

//        val url = URL("https://ttsmp3.com/makemp3_new.php")
//        val conn = url.openConnection() as HttpURLConnection
//        conn.requestMethod = "POST"
//        conn.doOutput = true
//        val writer = OutputStreamWriter(conn.outputStream)
//        writer.write("lang=Salli&source=ttsmp3&msg=$word")
//        writer.flush()
//        writer.close()
//        conn.outputStream.close()
//        var responseStream =
//            if (conn.responseCode / 100 == 2) conn.inputStream else conn.errorStream
//        if ("gzip" == conn.contentEncoding) {
//            responseStream = GZIPInputStream(responseStream)
//        }
//        val s = Scanner(responseStream).useDelimiter("\\A")
//        val response = if (s.hasNext()) s.next() else ""
//        val mainObject = JSONObject(response)
//        return mainObject.getString("URL")
//    }

    fun getInputStream(word: String): ResponseBody? {
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())

//        Log.d("MyLog", url)
        val request = Request.Builder().url(getUrlMp3(word)).build()
        val response = OkHttpClient().newCall(request).execute()

        return response.body
    }

//    private fun writeToFile(inputStream: InputStream, path: String) {
//        val rbc = Channels.newChannel(inputStream)
//        val fos = FileOutputStream(path)
//
//        // Перенаправляем данные из ReadableByteChannel прямо канал файла.
//        // Говорят, так быстрее, чем по одному байту вычитывать из потока и писать в файл.
//        var filePosition: Long = 0
//        var transferredBytes = fos.channel.transferFrom(rbc, filePosition, Long.MAX_VALUE)
//        while (transferredBytes == Long.MAX_VALUE) {
//            filePosition += transferredBytes
//            transferredBytes = fos.channel.transferFrom(rbc, filePosition, Long.MAX_VALUE)
//        }
//        rbc.close()
//        fos.close()
//    }
//    fun getAudio(engWord: String, path: String): Boolean {
//        return try {
//            writeToFile(getInputStream(engWord), path)
//            true
//        } catch (ex: java.lang.Exception) {
//            false
//        }
//    }
}