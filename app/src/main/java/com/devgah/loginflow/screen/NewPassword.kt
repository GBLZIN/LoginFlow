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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NewReleases
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devgah.loginflow.ui.theme.Green_Beaut

@Composable
fun CheckInfo() {
    var currentScreen by rememberSaveable { mutableStateOf("login") }

    when (currentScreen) {
        "page" -> Page(
            onLoginSucess = { currentScreen = "login" },
            onForgotPassword = { currentScreen = "forgot" }
        )
    }
}

@Composable
fun NewPassword(onBack: () -> Unit, onPage: () -> Unit, onNewPassword: () -> Unit) {

    var newPassword by rememberSaveable { mutableStateOf("") }
    var passwordConfirm by rememberSaveable { mutableStateOf("") }
    var showPassword by rememberSaveable { mutableStateOf(false) }
    val focus = LocalFocusManager.current
    val context = LocalContext.current
    val minChar = 8

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focus.clearFocus()
                })
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Icon(
                imageVector = Icons.Filled.NewReleases,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .offset(y = (-40).dp)
                    .size(45.dp)
            )

            Text(
                text = "Crie uma nova senha",
                color = Green_Beaut,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.offset(y = (-30).dp)
            )
            Text(
                text = "Escolha uma nova senha segura",
                color = Color.White,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.offset(y = (-23).dp)
            )

            Text(
                text = "com pelo menos 8 caracteres.",
                color = Color.White,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.offset(y = (-23).dp)
            )
            Spacer(modifier = Modifier.height(6.dp))

            OutlinedTextField(
                modifier = Modifier.width(325.dp),
                value = newPassword,
                onValueChange = {
                    newPassword = it
                },
                placeholder = {
                    Text(
                        text = "Senha nova",
                        color = Color.White
                    )
                },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedTextColor = Color.White,
                    focusedTextColor = Color.White,
                    focusedBorderColor = Green_Beaut,
                    cursorColor = Color.White
                ),
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(
                        onClick = { showPassword = !showPassword })
                    {
                        Icon(
                            imageVector = if (showPassword) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                            contentDescription = if (showPassword) "Exibir Senha" else "Senha Oculta",
                            tint = Color.White
                        )
                    }
                },
                shape = RoundedCornerShape(10.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
                OutlinedTextField(
                    modifier = Modifier.width(325.dp),
                    value = passwordConfirm,
                    onValueChange = {
                        passwordConfirm = it
                    },
                    placeholder = {
                        Text(
                            text = "Confirmar nova senha",
                            color = Color.White
                        )
                    },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.White,
                        focusedTextColor = Color.White,
                        focusedBorderColor = Green_Beaut,
                        cursorColor = Color.White
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    shape = RoundedCornerShape(10.dp)
                )
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    when {
                        newPassword.isBlank() || passwordConfirm.isBlank()
                           -> Toast.makeText(context, "É preciso preencher os campos!", Toast.LENGTH_SHORT).show()
                        newPassword.length < minChar
                           -> Toast.makeText(context, "A senha deve ter ao menos $minChar caracteres", Toast.LENGTH_SHORT).show()
                        newPassword != passwordConfirm
                           -> Toast.makeText(context, "As senhas não correspondem", Toast.LENGTH_SHORT).show()
                        else -> onPage()
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
                    text = "Confirmar",
                    color = Color.White
                )
            }
        }
    }
}