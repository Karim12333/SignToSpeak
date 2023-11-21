package com.mobilearchitects.signtospeak.ui.screens.mainpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobilearchitects.signtospeak.R
import com.mobilearchitects.signtospeak.ui.theme.AppBlue
import com.mobilearchitects.signtospeak.ui.theme.AppGrey
import com.mobilearchitects.signtospeak.ui.theme.AppLightBlue
import com.mobilearchitects.signtospeak.ui.theme.AppLightestBlue
import com.mobilearchitects.signtospeak.ui.theme.linearGradientTextColors
import com.mobilearchitects.signtospeak.ui.theme.nunitoSansFontFamily

@Composable
fun HomeScreen(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .padding(top = 30.dp)
    ) {
        Text(
            text = "Hello, iyad!",
            fontFamily = nunitoSansFontFamily,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                fontSize = 30.sp,
                brush = Brush.verticalGradient(
                    colors = linearGradientTextColors
                )
            )
        )


        Spacer(modifier = Modifier.height(16.dp))

        // Box to hold the profile picture frame
        Box(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = AppBlue,
                    shape = RoundedCornerShape(size = 12.dp)
                )
                .width(115.05382.dp)
                .height(115.38629.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(12.dp))
            )
        }

        Spacer(modifier = Modifier.height(37.dp))

        //cards
        Column(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .width(290.dp)
            .height(200.dp),
            horizontalAlignment = Alignment.Start
        )
        {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(28.dp)
                    .background(
                        color = AppBlue,
                        shape = RoundedCornerShape(size = 12.dp)
                    )
            ) {
                Text(
                    text = "Statistics",
                    fontFamily = nunitoSansFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()

            ){
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = AppLightestBlue,
                    ),
                    modifier = Modifier
                        .size(width = 130.dp, height = 100.dp)
                        .border(1.dp, AppLightBlue, shape = RoundedCornerShape(8.dp))

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Fire Icon
                        Image(
                            painter = painterResource(id = R.drawable.ic_fire), // Replace with your actual vector drawable ID
                            contentDescription = null,
                            modifier = Modifier.size(26.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "12",
                            textAlign = TextAlign.Center,
                            fontSize = 22.sp,
                            fontFamily = nunitoSansFontFamily,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                    Text(
                        text = "Day Streak",
                        modifier = Modifier
                            .padding(start = 16.dp),
                        textAlign = TextAlign.Center,
                        color = AppGrey,
                        fontSize = 17.sp,
                        fontFamily = nunitoSansFontFamily,
                        fontWeight = FontWeight.Light
                    )
                }

                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = AppLightestBlue,
                    ),
                    modifier = Modifier
                        .size(width = 130.dp, height = 100.dp)
                        .border(1.dp, AppLightBlue, shape = RoundedCornerShape(8.dp))

                ) {
                    Text(
                        text = "Beginner",
                        modifier = Modifier
                            .padding(16.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 22.sp,
                        fontFamily = nunitoSansFontFamily,
                        fontWeight = FontWeight.Normal,
                    )
                    Text(
                        text = "Tier",
                        modifier = Modifier
                            .padding(start = 16.dp),
                        textAlign = TextAlign.Center,
                        color = AppGrey,
                        fontSize = 17.sp,
                        fontFamily = nunitoSansFontFamily,
                        fontWeight = FontWeight.Light

                    )
                }
            }
        }

    }
}