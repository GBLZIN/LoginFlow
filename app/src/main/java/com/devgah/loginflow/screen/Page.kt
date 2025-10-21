package com.devgah.loginflow.screen

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.ThumbUpOffAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.devgah.loginflow.components.MsgInfo
import com.devgah.loginflow.ui.theme.Blue_Beaut
import com.devgah.loginflow.ui.theme.Green_Beaut
import com.devgah.loginflow.ui.theme.Pink_Beaut

@Composable
fun Page(onBack: () -> Unit, email: String) {
    var showLikeButton by remember { mutableStateOf(false) }
    var showInfoButton by remember { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(
        targetValue = if (showLikeButton) 360f else 0f,
        label = "rotation"
    )
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Card(
                shape = RoundedCornerShape(15.dp),
                border = BorderStroke(2.dp, color = Blue_Beaut)
            ) {
                Column {
                    Box {
                        AsyncImage(
                            model = "https://img.freepik.com/free-vector/hand-drawn-labour-day-background_23-2149363125.jpg",
                            contentDescription = null,
                            modifier = Modifier
                                .height(200.dp)
                                .fillMaxWidth()
                                .clip(
                                    RoundedCornerShape(
                                        topStart = 20.dp,
                                        topEnd = 20.dp
                                    )
                                ),
                            contentScale = ContentScale.Crop,
                        )

                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = null,
                            tint = Color.LightGray,
                            modifier = Modifier
                                .align(alignment = Alignment.TopEnd)
                                .offset(y = 200.dp)
                                .padding(16.dp)
                                .clickable { showInfoButton = !showInfoButton }
                        )
                    }

                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Manutenção",
                            fontSize = 24.sp
                        )
                        Text(
                            text = "Esta página está em desenvolvimento...",
                            fontSize = 14.sp
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(
                            onClick = {
                                showLikeButton = !showLikeButton
                                if (showLikeButton) {
                                    Toast.makeText(context, "Marcado como Gostei!", Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(context, "Gostei removido!", Toast.LENGTH_SHORT).show()
                                }
                            },
                            modifier = Modifier.size(40.dp)
                        ) {
                            Icon(
                                if (showLikeButton) Icons.Filled.ThumbUp else Icons.Filled.ThumbUpOffAlt,
                                contentDescription = null,
                                tint = if (showLikeButton) Pink_Beaut else Color.White,
                                modifier = Modifier.rotate(rotationAngle),
                            )
                        }

                        Button(
                            onClick = {
                                onBack()
                            },
                            contentPadding = PaddingValues(
                                horizontal = 16.dp,
                                vertical = 8.dp
                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Green_Beaut
                            ),
                            modifier = Modifier.height(40.dp),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(
                                text = "Voltar ao Menu",
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }

        AnimatedVisibility(
            visible = showInfoButton,
            modifier = Modifier
                .align(alignment = Alignment.TopEnd)
                .offset(y = 327.dp)
                .padding(40.dp)
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.width(250.dp)
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    MsgInfo()
                }
            }
        }
        Text(
            text = "Olá, $email",
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(horizontal = 16.dp, vertical = 32.dp),
            fontSize = 16.sp,
            color = Color.DarkGray
        )
    }
}
