package com.mobilearchitects.signtospeak.authenticationScreens
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.mobilearchitects.signtospeak.ui.theme.AppBlue
import com.mobilearchitects.signtospeak.ui.theme.nunitoSansFontFamily


@Composable
fun NormalTextComponent(value: String){
    Text(
        text = value,
        style = TextStyle(
            fontSize = 23.sp,
            fontFamily = nunitoSansFontFamily,
            fontWeight = FontWeight(700),
            color = Color(0xE5FFFFFF),
            textAlign = TextAlign.Center,
        )
    )
}
@Composable
fun FilledButton(text: String,  onClick: () -> Unit){
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .shadow(
                elevation = 2.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            )
            .border(
                width = 1.dp,
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(size = 6.dp)
            )
            .width(270.dp)
            .height(37.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(size = 12.dp),
            )

    ) {
        Text(
            text = text,
            modifier = Modifier
                .width(89.85222.dp)
                .height(36.05767.dp),
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = nunitoSansFontFamily,
                fontWeight = FontWeight(500),
                color = AppBlue,
                textAlign = TextAlign.Center,
            )
        )
    }
}
@Composable
fun NotFilledButton(text: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .shadow(
                elevation = 2.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            )
            .border(
                width = 1.dp,
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(size = 6.dp)
            )
            .width(270.dp)
            .height(37.dp)
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(size = 12.dp),
            )
    ) {
        Text(
            text = text,
            modifier = Modifier
                .width(89.85222.dp)
                .height(36.05767.dp),
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = nunitoSansFontFamily,
                fontWeight = FontWeight(500),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputText(hint: String, text: String , onTextChange:(String)->Unit) {
    var isHintVisible by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .shadow(elevation = 2.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000))
            .border(width = 1.5.dp, color = Color(0xCCFFFFFF), shape = RoundedCornerShape(size = 6.dp))
            .width(270.dp)
            .height(37.dp)
            .background(color = Color(0x66FFFFFF), shape = RoundedCornerShape(size = 6.dp))
    )

    {
        BasicTextField(
            value = text,
            onValueChange = {
                onTextChange(it);
                isHintVisible = it.isEmpty()
            },
            textStyle = TextStyle(
                fontSize = 16.sp,
                fontFamily = nunitoSansFontFamily,
                fontWeight = FontWeight(400),
                color = Color.Black,
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 8.dp)
        )

        if (isHintVisible) {
            Text(
                text = hint,
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 8.dp)
                    .height(17.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = nunitoSansFontFamily,
                    fontWeight = FontWeight(400),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}
