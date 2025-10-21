package com.devgah.loginflow.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devgah.loginflow.ui.theme.Border
import com.devgah.loginflow.ui.theme.Green_Beaut
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ForgotPassword(onBack: () -> Unit, onVerifyCode: () -> Unit) {
    var email by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val focus = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focus.clearFocus()
                })
            }
    )
    {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .offset(y = (-40).dp)
                    .size(45.dp)
            )

            Text(
                text = "Redefinir sua senha",
                color = Green_Beaut,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.offset(y = (-30).dp)
            )
            Text(
                text = "Digite o email da sua conta para enviarmos",
                color = Color.White,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.offset(y = (-23).dp)
            )

            Text(
                text = "um link para redefinir sua senha.",
                color = Color.White,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.offset(y = (-23).dp)
            )

            Spacer(modifier = Modifier.height(6.dp))
            OutlinedTextField(
                modifier = Modifier.width(325.dp),
                value = email,
                onValueChange = {
                    email = it
                },
                placeholder = {
                    Text(
                        text = "Digite o seu Email"
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Green_Beaut,
                    unfocusedBorderColor = Border
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = {
                    if (email.isBlank()) {
                        Toast.makeText(context, "É preciso preencher o campo!", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        coroutineScope.launch {
                            delay(500)
                            Toast.makeText(
                                context,
                                "Email de recuperação enviado para $email",
                                Toast.LENGTH_SHORT
                            ).show()
                            onVerifyCode()
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Green_Beaut
                ),
                modifier = Modifier
                    .width(325.dp)
                    .offset(y = 8.dp),
                shape = RoundedCornerShape(10.dp)
            )
            {
                Text(
                    text = "Enviar email para redefinição de Senha",
                    color = Color.White
                )
            }

            Button(
                onClick = {
                    onBack()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .offset(y = 5.dp),
                shape = RoundedCornerShape(10.dp)
            )
            {
                Text(
                    text = "Voltar",
                    color = Color.White
                )
            }

        }
    }
}