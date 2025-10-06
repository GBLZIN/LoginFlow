package com.devgah.loginflow.screen

import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.ThumbUpOffAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.devgah.loginflow.ui.theme.Blue_Beaut
import com.devgah.loginflow.ui.theme.Green_Beaut
import com.devgah.loginflow.ui.theme.Pink_Beaut

@Composable
fun InfosChecking() {
    var currentScreen by rememberSaveable { mutableStateOf("login") }

    when (currentScreen) {
        "login" -> Login(
            onLoginSucess = { currentScreen = "page" },
            onForgotPassword = { currentScreen = "forgot"},
            onSignUp = {currentScreen = "signUp"}
        )
    }
}

@Composable
fun Page(onLoginSucess: () -> Unit, onForgotPassword: () -> Unit) {
    var showLikeButton by remember { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(
        targetValue = if (showLikeButton) 360f else 0f,
        label = "rotation"
    )
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(2.dp, color = Blue_Beaut)
        ) {
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
                        onLoginSucess()
                    },
                    contentPadding = PaddingValues(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Green_Beaut
                    ),
                    modifier = Modifier.height(40.dp)
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