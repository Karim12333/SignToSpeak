import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mobilearchitects.signtospeak.authenticationScreens.InputText
import com.mobilearchitects.signtospeak.authenticationScreens.NotFilledButton
import com.mobilearchitects.signtospeak.ui.Retrofit.RetrofitApiService
import com.mobilearchitects.signtospeak.ui.Retrofit.UserResponse
import com.mobilearchitects.signtospeak.ui.theme.SignToSpeakTheme
import com.mobilearchitects.signtospeak.ui.theme.nunitoSansFontFamily
import kotlinx.coroutines.launch

class SignupViewModel : ViewModel() {
    suspend fun signUp(isSuccessful: MutableState<Boolean>,firstname: String, lastname: String, username: String, email: String,  password: String, password_confirmed: String) {
        viewModelScope.launch {
            try {
                val request = UserResponse(firstname,lastname,username,email,password,false)

                val response = RetrofitApiService().api.signUp(request);
                isSuccessful.value = response.isSuccessful
            } catch (e: Exception) {
                // error
            }
        }
    }
}

@Composable
fun signUp(navController: NavController) {
    val SignupViewModel = viewModel<SignupViewModel>()

    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var password_confirmed by remember { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope();

    val isSuccessful = remember {
        mutableStateOf(false)
    }

    fun checkIfSuccessful(){
        if (isSuccessful.value){
            //navigate to login
        }
    }

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
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontFamily = nunitoSansFontFamily,)) {
                            append("Create an account")
                        }
                        append("\nto get started ")
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
            InputText(hint = "First Name", text = firstname, onTextChange = {firstname = it})
            Spacer(modifier = Modifier.height(20.dp))
            InputText(hint = "Last Name", text = lastname, onTextChange = {lastname = it})
            Spacer(modifier = Modifier.height(20.dp))
            InputText(hint = "Username", text = username, onTextChange = {username = it})
            Spacer(modifier = Modifier.height(20.dp))
            InputText(hint = "Email", text = email, onTextChange = {email = it})
            Spacer(modifier = Modifier.height(20.dp))
            InputText(hint = "Password", text = password, onTextChange = {password = it})
            Spacer(modifier = Modifier.height(20.dp))
            InputText(hint = "Confirm Password", text = password_confirmed, onTextChange = {password_confirmed = it})
            Spacer(modifier = Modifier.height(40.dp))
            NotFilledButton(text = "Sign Up") {
                coroutineScope.launch {
                    SignupViewModel.signUp(
                        isSuccessful,
                        firstname,
                        lastname,
                        username,
                        email,
                        password,
                        password_confirmed
                    )
                }
                checkIfSuccessful()
            }
            checkIfSuccessful()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun signUpPreview() {
    val navController = rememberNavController()
    SignToSpeakTheme{
        signUp(navController = navController)
    }

}
