import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mobilearchitects.signtospeak.authenticationScreens.FilledButton
import com.mobilearchitects.signtospeak.authenticationScreens.InputText
import androidx.navigation.compose.rememberNavController
import com.mobilearchitects.signtospeak.ui.screens.authenticationScreens.SplashScreen
import com.mobilearchitects.signtospeak.ui.theme.SignToSpeakTheme
import com.mobilearchitects.signtospeak.ui.theme.nunitoSansFontFamily

@Composable
fun LogIn(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    0.0f to Color(0xFF28B4F7),
                    0.2f to Color(0xFF46A4F7), // Gradual transition to green
                    1.0f to Color(0xFF72EFD8),
                    start = Offset.Zero,
                    end = Offset.Infinite
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(360.dp)
                .height(800.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(400.dp)
                    .height(250.dp)
                    .padding(top = 100.dp)

            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,
                            fontFamily = nunitoSansFontFamily))
                        {
                            append("Welcome.")
                        }
                        append("\nGood to see you! ")
                    },
                    style = TextStyle(
                        fontFamily = nunitoSansFontFamily,
                        fontSize = 23.sp,
                        color = Color(0xE5FFFFFF),
                        textAlign = TextAlign.Center,
                    )
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            InputText(hint = "Username")
            Spacer(modifier = Modifier.height(20.dp))
            InputText(hint = "Password")
            Spacer(modifier = Modifier.height(10.dp))
            ClickableText(
                text = AnnotatedString("forgot password?"),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = nunitoSansFontFamily,
                    fontWeight = FontWeight(400),
                    color = Color.White,
                    textAlign = TextAlign.End,
                ),
                modifier = Modifier
                    .padding(start = 160.dp),
                onClick = { offset ->
                    // Handle click action here
                }
            )
            Spacer(modifier = Modifier.height(40.dp))
            FilledButton(text = "Login", { /*TODO*/ })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    val navController = rememberNavController()
    SignToSpeakTheme{
        LogIn(navController = navController)
    }

}
