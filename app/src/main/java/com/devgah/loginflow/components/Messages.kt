package com.devgah.loginflow.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.devgah.loginflow.ui.theme.Blue_Beaut
import com.devgah.loginflow.ui.theme.Green_Code

@Composable
fun MsgInfo() {
    val annotated = buildAnnotatedString {

        withStyle(
            SpanStyle(
                color = Color.DarkGray
            )
        ) {
            append("Página principal do \nAplicativo. ")
        }

        withLink(
            LinkAnnotation.Url(
                url = "https://github.com/GBLZIN",
                styles = TextLinkStyles(
                    style = SpanStyle(
                        color = Blue_Beaut
                    )
                )
            )
        ) {
            append("Saiba mais")
        }
    }

    Text(
        text = annotated
    )
}

@Composable
fun NewCode() {
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = Unit) {
        isVisible = true
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 42.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Verified,
            contentDescription = null,
            tint = Green_Code,
            modifier = Modifier.size(size = 22.dp)
        )

        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn() + expandVertically() + slideInVertically(),
            exit = fadeOut() + shrinkVertically() + slideOutVertically()
        )
        {
            Text(
                text = " Enviamos outro código a você",
                color = Green_Code
            )
        }
    }
}