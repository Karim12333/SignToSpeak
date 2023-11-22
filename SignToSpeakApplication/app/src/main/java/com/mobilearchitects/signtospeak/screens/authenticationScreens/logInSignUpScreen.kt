
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import com.mobilearchitects.signtospeak.R
import com.mobilearchitects.signtospeak.authenticationScreens.FilledButton
import com.mobilearchitects.signtospeak.authenticationScreens.NotFilledButton
import com.mobilearchitects.signtospeak.ui.theme.SignToSpeakTheme

@Composable
fun MainScreen(navController: NavController){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "logInSignUpScreen")
    {
        composable("logInSignUpScreen"){
            logInSignUpScreen(navController = navController)
        }
        composable("logIn"){
            LogIn(navController = navController)
        }
        composable("signUp"){
            signUp(navController = navController)
        }
    }
}


@Composable
fun logInSignUpScreen(navController: NavController) {
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
                    .height(300.dp)
                    .padding(top = 100.dp)

            ) {
                // Image component with specified Modifier
                Image(
                    painter = painterResource(id = R.drawable.signlogo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .width(200.dp)
                        .height(150.dp)
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            FilledButton(text = "Login", { navController.navigate("logIn") })
            Spacer(modifier = Modifier.height(20.dp))
            NotFilledButton(text = "Sign Up",{ navController.navigate("signUp")})
        }
    }
}
@Preview(showBackground = true)
@Composable
fun MainPreview() {
    val navController = rememberNavController()
    SignToSpeakTheme{
        MainScreen(navController = navController)
    }

}