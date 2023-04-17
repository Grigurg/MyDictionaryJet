package com.grig.mydictionaryjet.presentation.words_show.common.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grig.mydictionaryjet.R
import com.grig.mydictionaryjet.domain.model.Word
import com.grig.mydictionaryjet.presentation.words_show.common.WordsItemEvent

@Composable
fun WordItem(
//    wordItemState: WordsItemState,
    expanded: Boolean,
    speaking: Boolean,
    word: Word,
    onEvent: (WordsItemEvent) -> Unit,
) {
//    val expanded = wordItemState.isExpanded
//    val speaking = wordItemState.speaking
//    val word = wordItemState.word

    val rotationArrowAngle by animateFloatAsState(
        targetValue = if (!expanded) 180f else 0f, animationSpec = tween(durationMillis = 500)
    )


    Box(
        modifier = Modifier
            .fillMaxWidth()
//            .height(si.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable { onEvent(WordsItemEvent.ClickItem) }
            .background(color = MaterialTheme.colors.surface),
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .padding(start = 6.dp)
                    .height(70.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(30.dp)
                        .pointerInput(Unit) {
                            detectTapGestures {
                                onEvent(WordsItemEvent.ClickTalker)
                            }
                        },
//                    .background(Color.Red),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = if (!speaking) R.drawable.dont_speak else R.drawable.speaking),
                        contentDescription = "speakImg",
                        modifier = Modifier.size(25.dp),
                    )
                }
                Spacer(modifier = Modifier.size(10.dp))
                Column {
                    Text(
                        text = word.engWord,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight(450),
                            fontFamily = FontFamily.SansSerif
                        ),
//                        modifier = Modifier.padding(top = 10.dp)
                    )
//                    Spacer(modifier = Modifier.size(50.dp))
                    AnimatedVisibility(visible = expanded) {
                        Text(
                            text = word.rusWord,
                            modifier = Modifier.padding(vertical = 5.dp)
                        )
                    }
//                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "arrowImg",
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface.copy(alpha = 0.7f)),
                    modifier = Modifier
                        .rotate(rotationArrowAngle)
                        .size(30.dp)
                )
            }
            AnimatedVisibility(visible = expanded) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, bottom = 10.dp, end = 20.dp)
//                    .height(100.dp)
//                    .background(Color.Red)
                ) {
                    Column {
                        if (!word.example.isNullOrBlank()) {
                            Text(text = word.example, Modifier.padding(vertical = 10.dp))
//                        Spacer(modifier = Modifier.size(2.dp))
//                        if (word.)
                        }
                    }
                }
            }
        }
    }
}