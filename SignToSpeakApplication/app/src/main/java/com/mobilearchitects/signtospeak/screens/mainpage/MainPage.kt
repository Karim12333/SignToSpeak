@file:OptIn(ExperimentalPermissionsApi::class)

package com.mobilearchitects.signtospeak.screens.mainpage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobilearchitects.signtospeak.R
import com.mobilearchitects.signtospeak.screens.profile.ProfileScreen
import com.mobilearchitects.signtospeak.ui.theme.AppBlack
import com.mobilearchitects.signtospeak.ui.theme.AppBlue
import com.mobilearchitects.signtospeak.ui.theme.AppGrey
import com.mobilearchitects.signtospeak.ui.theme.AppLightBlue
import com.mobilearchitects.signtospeak.ui.theme.AppLightestBlue
import com.mobilearchitects.signtospeak.ui.theme.nunitoSansFontFamily
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.mobilearchitects.signtospeak.screens.mainpage.camera.CameraScreen


@Composable
fun MainPageScreen(){

    //check if my app has camera permission
    val cameraPermissionState: PermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        MainCamScreen(
            hasPermission = cameraPermissionState.status.isGranted,
            onRequestPermission = cameraPermissionState::launchPermissionRequest
        )


        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = AppLightestBlue,
            ),
            modifier = Modifier
                .size(width = 330.dp, height = 161.dp)

        ) {
            Text(
                text = "English",
                modifier = Modifier
                    .padding(12.dp),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                color = AppBlue,
                fontFamily = nunitoSansFontFamily,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                        "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                modifier = Modifier
                    .padding(start = 12.dp),
                textAlign = TextAlign.Start,
                color = AppBlack,
                fontSize = 18.sp,
                fontFamily = nunitoSansFontFamily,
                fontWeight = FontWeight.Normal,

            )
        }

    }
}

@Composable
fun MainCamScreen(
    hasPermission: Boolean,
    onRequestPermission: () -> Unit
){
    if (hasPermission) {
        CameraScreen()
    } else {
        NoPermissionScreen(onRequestPermission)
    }


}



@Preview(showBackground = true)
@Composable
fun MyMainScreenPreview() {
    MainCamScreen(
        hasPermission = true,
        onRequestPermission = {}
    )
}