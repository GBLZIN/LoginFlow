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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.MarkEmailUnread
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devgah.loginflow.components.NewCode
import com.devgah.loginflow.ui.theme.Blue_Beaut
import com.devgah.loginflow.ui.theme.Green_Beaut

@Composable
fun VerifyCode(onNewPassword: () -> Unit) {

    var code by rememberSaveable { mutableStateOf("") }
    val maxChar = 6
    val context = LocalContext.current
    val focus = LocalFocusManager.current
    var showNewCode by rememberSaveable { mutableStateOf(false) }

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
                imageVector = Icons.Filled.MarkEmailUnread,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .offset(y = (-40).dp)
                    .size(45.dp)
            )

            Text(
                text = "Insira o código de 6 dígitos",
                color = Green_Beaut,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.offset(y = (-30).dp)
            )
            Text(
                text = "Enviamos um código de verificação",
                color = Color.White,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.offset(y = (-23).dp)
            )

            Text(
                text = "para o seu email.",
                color = Color.White,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.offset(y = (-23).dp)
            )
            Spacer(modifier = Modifier.height(6.dp))

            if (showNewCode) {
                NewCode()
                Spacer(modifier = Modifier.height(height = 8.dp))
            }

            OutlinedTextField(
                modifier = Modifier.width(325.dp),
                value = code,
                onValueChange = {
                    if (it.length <= maxChar) {
                        code = it
                    }
                },
                placeholder = {
                    Text(
                        text = "Código de 6 dígitos",
                        color = Color.White
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedTextColor = Color.White,
                    focusedTextColor = Color.White,
                    focusedBorderColor = Green_Beaut,
                    cursorColor = Color.White
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Code,
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                shape = RoundedCornerShape(10.dp)
            )
            Spacer(modifier = Modifier.height(3.dp))

            TextButton(
                onClick = {
                    showNewCode = true
                },
                modifier = Modifier
                    .align(alignment = Alignment.Start)
                    .padding(horizontal = 32.dp)
            ) {
                Text(
                    text = "Reenviar código",
                    color = Blue_Beaut,
                    fontWeight = FontWeight.Normal
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    when {
                        code.isBlank() -> {
                            Toast.makeText(context, "É preciso preencher o campo!", Toast.LENGTH_SHORT)
                                .show()
                        }
                        code.length < 6 -> {
                            Toast.makeText(context, "insira 6 dígitos!", Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            Toast.makeText(context, "Código válido!", Toast.LENGTH_SHORT).show()
                            onNewPassword()
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
                    text = "Confirmar",
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text =
                    """
                Não recebeu o email? Confira o spam. 
                Se não estiver lá, verifique o email.  
                Talvez não haja uma conta cadastrada.
            """.trimIndent(),
                color = Color.LightGray,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(alignment = Alignment.Start)
                    .padding(horizontal = 44.dp)
            )
        }
    }
}