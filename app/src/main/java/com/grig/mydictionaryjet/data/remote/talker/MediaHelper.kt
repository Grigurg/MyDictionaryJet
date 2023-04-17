//package com.grig.mydictionaryjet.data.remote.talker
//
//import android.content.Context
//import android.media.MediaPlayer
//import android.media.PlaybackParams
//import android.net.Uri
//import android.os.Build
//import android.os.Handler
//import android.os.Looper
//import android.util.Log
//import androidx.annotation.RequiresApi
//import okhttp3.ResponseBody
//import java.io.*
//import javax.inject.Inject
//
//class MediaHelper @Inject constructor(
////    private val engWord: String,
//    private val context: Context
//) {
//    private val path: String = context.filesDir.absolutePath
////    private val path = "${context.filesDir.absolutePath}/$engWord"
//
//    //    fun saveFile(body: ResponseBody?): Boolean {
////        val rbc = Channels.newChannel(inputStream)
////        val fos = FileOutputStream(basePath)
////
////        // Перенаправляем данные из ReadableByteChannel прямо канал файла.
////        // Говорят, так быстрее, чем по одному байту вычитывать из потока и писать в файл.
////        var filePosition: Long = 0
////        var transferredBytes = fos.channel.transferFrom(rbc, filePosition, Long.MAX_VALUE)
////        while (transferredBytes == Long.MAX_VALUE) {
////            filePosition += transferredBytes
////            transferredBytes = fos.channel.transferFrom(rbc, filePosition, Long.MAX_VALUE)
////        }
////        rbc.close()
////        fos.close()
////    }
//
//
//    private fun writeResponseBodyToDisk(body: ResponseBody, engWord: String): Boolean {
//        return try {
//            // todo change the file location/name according to your needs
//            val audioFile = File(getPathToFile(engWord))
//            var inputStream: InputStream? = null
//            var outputStream: OutputStream? = null
//            try {
//                val fileReader = ByteArray(4096)
//                val fileSize = body.contentLength()
//                var fileSizeDownloaded: Long = 0
//                inputStream = body.byteStream()
//                outputStream = FileOutputStream(audioFile)
//                while (true) {
//                    val read = inputStream.read(fileReader)
//                    if (read == -1) {
//                        break
//                    }
//                    outputStream.write(fileReader, 0, read)
//                    fileSizeDownloaded += read.toLong()
//                    Log.d("File Download: ", "$fileSizeDownloaded of $fileSize")
//                }
//                outputStream.flush()
//                true
//            } catch (e: IOException) {
//                false
//            } finally {
//                inputStream?.close()
//                outputStream?.close()
//            }
//        } catch (e: IOException) {
//            false
//        }
//    }
//
//    private suspend fun getAudioFromApi(engWord: String): ResponseBody {
////        val body =
////            RetrofitClient.getInstance().create(TalkerApi::class.java).getAudio(engWord).body()
////        Log.d("MyLog", RetrofitClient2.getInstance().create(TalkerApi2::class.java).getAudio(engWord).body()?.string().toString())
//        val body =
//            RetrofitClient.getInstance()
//                .create(TalkerApi::class.java).getAudio(engWord).body()
//                ?: TalkerApiClient().getInputStream(engWord)
//        Log.d("MyLog", "body is ${body?.string()}")
//        return body!!
////        return RetrofitClient.getInstance().create(TalkerApi::class.java).getAudio(engWord).body()
//    }
//
//    private suspend fun getReady(engWord: String): Boolean {
//        return if (!isAudioExist(engWord))
//            writeResponseBodyToDisk(getAudioFromApi(engWord), engWord)
//        else
//            true
////        return if (!isAudioExist()) {
////            saveFile(getAudioFromApi())
////        } else true
//    }
//
//    private fun isAudioExist(engWord: String): Boolean = File(getPathToFile(engWord)).exists()
//
//    @RequiresApi(Build.VERSION_CODES.M)
//    suspend fun sayWord(onCompletion: () -> Unit = {}, engWord: String) {
//        Log.d("MyLog", "$engWord + $path")
//        if (!getReady(engWord)) {
//            onCompletion()
//            return
//        }
//        val mediaPlayer = MediaPlayer.create(context, Uri.parse(getPathToFile(engWord)))
//        val playbackParams = PlaybackParams()
//        playbackParams.speed = 0.8f
//        mediaPlayer.playbackParams = playbackParams
//
//        mediaPlayer.start()
//        mediaPlayer.setOnCompletionListener {
//            Handler(Looper.getMainLooper()!!).postDelayed(
//                { onCompletion() },
//                100
//            )
//        }
//    }
//
//    private fun getPathToFile(engWord: String) = path + File.separator + engWord
//}

package com.grig.mydictionaryjet.data.remote.talker

import android.content.Context
import android.media.MediaPlayer
import android.media.PlaybackParams
import android.net.Uri
import android.os.Handler
import android.os.Looper
import okhttp3.ResponseBody
import java.io.*
import javax.inject.Inject

class MediaHelper @Inject constructor(
//    private val engWord: String,
    private val context: Context
) {
    private var path = ""
    private var engWord = ""

    //    fun saveFile(body: ResponseBody?): Boolean {
//        val rbc = Channels.newChannel(inputStream)
//        val fos = FileOutputStream(basePath)
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


    private fun writeResponseBodyToDisk(body: ResponseBody): Boolean {
        return try {
            // todo change the file location/name according to your needs
            val audioFile = File(path)
            var inputStream: InputStream? = null
            var outputStream: OutputStream? = null
            try {
                val fileReader = ByteArray(4096)
//                val fileSize = body.contentLength()
                var fileSizeDownloaded: Long = 0
                inputStream = body.byteStream()
                outputStream = FileOutputStream(audioFile)
                while (true) {
                    val read = inputStream.read(fileReader)
                    if (read == -1) {
                        break
                    }
                    outputStream.write(fileReader, 0, read)
                    fileSizeDownloaded += read.toLong()
//                    Log.d("File Download: ", "$fileSizeDownloaded of $fileSize")
                }
                outputStream.flush()
                true
            } catch (e: IOException) {
                false
            } finally {
                inputStream?.close()
                outputStream?.close()
            }
        } catch (e: IOException) {
            false
        }
    }

    private suspend fun getAudioFromApi(): ResponseBody {
//        val body =
//            RetrofitClient.getInstance().create(TalkerApi::class.java).getAudio(engWord).body()
//        Log.d("MyLog", RetrofitClient2.getInstance().create(TalkerApi2::class.java).getAudio(engWord).body()?.string().toString())
        val body =
            RetrofitClient.getInstance().create(TalkerApi::class.java).getAudio(engWord).body()
                ?: TalkerApiClient().getInputStream(engWord)
        return body!!
//        return RetrofitClient.getInstance().create(TalkerApi::class.java).getAudio(engWord).body()
    }

    private suspend fun getReady(): Boolean {
        return if (!isAudioExist()) {
            writeResponseBodyToDisk(getAudioFromApi())
        } else {
    //            Log.d("MyLog", "File exists")
            true
        }
//        return if (!isAudioExist()) {
//            saveFile(getAudioFromApi())
//        } else true
    }

    private fun isAudioExist(): Boolean = File(path).exists()

    private fun init(engWord: String) {
        this.engWord = engWord
        path = "${context.filesDir.absolutePath}/$engWord"
    }

    suspend fun sayWord(engWord: String, onCompletion: () -> Unit = {}) {
        init(engWord)
        if (!getReady()) {
            onCompletion()
            return
        }
        val mediaPlayer = MediaPlayer.create(context, Uri.parse(path))
        val playbackParams = PlaybackParams()
        playbackParams.speed = 0.8f
        mediaPlayer.playbackParams = playbackParams

        mediaPlayer.start()
        mediaPlayer.setOnCompletionListener {
            Handler(Looper.getMainLooper()!!).postDelayed(
                { onCompletion() },
                100
            )
        }
    }
}