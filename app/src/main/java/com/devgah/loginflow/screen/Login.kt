package com.devgah.loginflow.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devgah.loginflow.ui.theme.Blue_Beaut
import com.devgah.loginflow.ui.theme.Border
import com.devgah.loginflow.ui.theme.Green_Beaut

@Composable
fun Login(onLoginSucess: (String) -> Unit, onForgotPassword: () -> Unit, onSignUp: () -> Unit) {
    var textEmail by rememberSaveable { mutableStateOf("") }
    var textPassword by rememberSaveable { mutableStateOf("") }
    var showPasword by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current
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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Olá novamente!",
                color = Green_Beaut,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.offset(y = (-30).dp)
            )

            Text(
                text = "Por favor, faça login com suas informações",
                color = Color.White,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.offset(y = (-33).dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            OutlinedTextField(
                modifier = Modifier.width(325.dp),
                value = textEmail,
                onValueChange = {
                    textEmail = it
                },
                placeholder = {
                    Text(
                        text = "Email"
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
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                modifier = Modifier.width(325.dp),
                value = textPassword,
                onValueChange = {
                    textPassword = it
                },
                placeholder = {
                    Text(
                        text = "Senha"
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Green_Beaut,
                    unfocusedBorderColor = Border
                ),
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                visualTransformation = if (showPasword) VisualTransformation.None else PasswordVisualTransformation(),
                leadingIcon = {

                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = { showPasword = !showPasword })
                    {
                        Icon(
                            imageVector = if (showPasword) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                            contentDescription = if (showPasword) "Exibir Senha" else "Senha Oculta",
                            tint = Color.White
                        )
                    }
                }
            )

            Text(
                text = "Esqueci minha senha",
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(vertical = 8.dp)
                    .padding(end = 42.dp)
                    .clickable {
                        onForgotPassword()
                    },
                color = Blue_Beaut,
                fontWeight = FontWeight.Normal,
            )

            Button(
                onClick = {
                    if (textEmail.isBlank() || textPassword.isBlank()) {
                        Toast.makeText(context, "É preciso preencher os campos!", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        if (textEmail.length < 3 || textPassword.length <= 3) {
                            Toast.makeText(
                                context,
                                "É preciso inserir no mínimo 4 caracteres!",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(context, "Logado com sucesso!", Toast.LENGTH_SHORT).show()
                            onLoginSucess(textEmail)
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Green_Beaut
                ),
                modifier = Modifier
                    .width(325.dp)
                    .offset(y = 27.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Entrar",
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(height = 25.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.White
                        )
                    ) {
                        append("Não tem uma conta? ")
                    }

                    withStyle(
                        style = SpanStyle(
                            color = Blue_Beaut
                        )
                    ) {
                        append("Cadastra-se")
                    }
                },
                modifier = Modifier.clickable {
                    onSignUp()
                },
                color = Color.Black,
                fontWeight = FontWeight.Normal
            )
        }
    }
}