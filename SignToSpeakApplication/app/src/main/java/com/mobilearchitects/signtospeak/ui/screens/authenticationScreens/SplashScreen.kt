package com.mobilearchitects.signtospeak.ui.screens.authenticationScreens
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobilearchitects.signtospeak.R
import kotlinx.coroutines.delay
@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(targetValue = 1f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(1500)
        navController.navigate("HomeScreen")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    0.0f to Color(0xFF479CF9),
                    700f to Color(0xFF71EED9),
                    1000f to Color(0xFF23D4B9),
                    start = Offset.Zero,
                    end = Offset.Infinite
                )
            ),
        contentAlignment = Alignment.Center
    )
    {
        Canvas(
            modifier = Modifier
                .width(446.dp)
                .height(410.dp)
                .padding()
                .graphicsLayer(
                    translationX = (-300).toFloat(),
                    translationY = (-1000).toFloat(),
                    alpha = 0.5f
                ),
            onDraw = {
                drawCircle(
                    color = Color(0xFF2BDDBE),
                )
            }
        )

        Canvas(
            modifier = Modifier
                .width(446.dp)
                .height(410.dp)
                .padding()
                .graphicsLayer(
                    translationX = (100).toFloat(), // Adjust the translation for the opposite side
                    translationY = (-1300).toFloat(),
                    alpha = 0.5f
                ),
            onDraw = {
                drawCircle(
                    color = Color(0xFF2BDDBE),
                )
            }
        )


        Column {
            Image(
                painter = painterResource(id = R.drawable.signlogo),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(200.dp)
                    .height(150.dp)
            )
        }
    }
}

