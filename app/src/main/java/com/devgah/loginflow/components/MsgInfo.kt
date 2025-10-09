package com.devgah.loginflow.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import com.devgah.loginflow.ui.theme.Blue_Beaut

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