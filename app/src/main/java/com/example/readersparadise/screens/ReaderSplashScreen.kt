package com.example.readersparadise.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.readersparadise.components.ReaderLogo
import com.example.readersparadise.navigation.ReaderScreens
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun ReaderSplashScreen(navController: NavController) {

    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(targetValue = 0.9f,
            animationSpec = tween(durationMillis = 800,
                easing = {
                    OvershootInterpolator(10f).getInterpolation(it)
                }
            ))

        delay(4000L)
        if (FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()) {
            navController.navigate(ReaderScreens.FirstPageT.name)
        }
        else {
            navController.navigate(ReaderScreens.FirstPageT.name)
        }

    }

    Surface(
        modifier = Modifier
            .padding(15.dp)
            .size(400.dp)
            .scale(scale.value),

        shape = CircleShape,
        color = Color.White,
        border = BorderStroke(
            width = 2.dp, color = Color.LightGray
        )
    ) {
        Column(
            modifier = Modifier.padding(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            ReaderLogo()
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "\"Read , Learn, Grow\"",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Gray.copy(alpha = 0.5f)
            )

            Spacer(modifier = Modifier.height(1.dp))

            // Add the code here to display the GIF
            Surface {
                Spacer(modifier =Modifier.height(20.dp))
                Column (modifier = Modifier.padding(1.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center){
                    AsyncImage(
                        model = "https://media.giphy.com/media/O8lwQCoALfzD312OAU/giphy.gif",
                        contentDescription = null,
                        modifier = Modifier
                            .size(175.dp)
                            .padding(10.dp)
                    )

                }

            }


        }

    }

}