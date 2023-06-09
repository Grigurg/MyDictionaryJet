package com.grig.mydictionaryjet.presentation

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grig.mydictionaryjet.presentation.theme.LightBlue

@Composable
fun DeprecatedVersionDialog() {
    val uriHandler = LocalUriHandler.current
    AlertDialog(onDismissRequest = { }, title = {
        Box(modifier = Modifier.height(140.dp)) {
            Column(modifier = Modifier.align(Center)) {
                Text(
                    text = "Your version of app has deprecated",
                    color = MaterialTheme.colors.error,
                )
                Spacer(modifier = Modifier.height(20.dp))
//                    val annotatedString =  buildAnnotatedString {
//                        append("DownLoad and install apk from ")
//                        pushStringAnnotation(tag = "download url", annotation = "https://github.com/Grigurg/MyDictionaryJet/raw/master/app/release/app-release.apk")
//                        withStyle(style = SpanStyle(color = MaterialTheme.colors.primary)) {
//                            append("this")
//                        }
//                    }
//                    ClickableText(text = annotatedString, onClick = {})
                Text(
                    text = " Download and install apk",
                )
                Text(text = "Download",
                    style = TextStyle(
                        fontStyle = FontStyle.Italic, color = LightBlue, fontSize = 22.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .pointerInput(Unit) {
                            detectTapGestures {
                                uriHandler.openUri("https://github.com/Grigurg/MyDictionaryJet/raw/master/app/release/app-release.apk")
                            }
                        })
//                    Text(
//                        text = "https://github.com/Grigurg/MyDictionaryJet/raw/master/app/release/app-release.apk",
//                        color = Color.Blue
//                    )
            }
        }
    }, buttons = {})
}

//fun showInstallOption(
//    destination: String,
////        uri: Uri,
//    context: Context
//): Intent {
//    // set BroadcastReceiver to install app when .apk is downloaded
//
//
////                    val contentUri = FileProvider.getUriForFile(
////                        context,
//////                        BuildConfig.APPLICATION_ID + "",
////                        File(destination)
////                    )
//
//    val install = Intent(Intent.ACTION_VIEW)
//    install.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
//    install.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//    install.putExtra(Intent.EXTRA_NOT_UNKNOWN_SOURCE, true)
//    install.data = destination.toUri()
//    return install
////                    context.startActivity(install)
////                    context.unregisterReceiver(context)
//    // finish()
//
////                    val install = Intent(Intent.ACTION_VIEW)
////                    install.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
////                    install.setDataAndType(
////                        uri,
////                        APP_INSTALL_PATH
////                    )
////                    context.startActivity(install)
////                    context.unregisterReceiver(this)
////                    // finish()
//
//
////        context.startActivity(IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
//}
