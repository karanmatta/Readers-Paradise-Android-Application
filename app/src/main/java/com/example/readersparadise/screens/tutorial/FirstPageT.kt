package com.example.readersparadise.screens.tutorial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.readersparadise.navigation.ReaderScreens

@Composable
fun FirstPage(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Image with content scale set to fill the entire screen
        Image(
            painter = painterResource(id = com.example.readersparadise.R.drawable.ic_1),
            contentDescription = "Tutorial First Page Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )

        // Column for the content at the bottom
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.Black.copy(alpha = 0.5f)),
            verticalArrangement = Arrangement.Center
        ) {
            // Text with description highlighted in a box
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = MaterialTheme.shapes.large,
                color = MaterialTheme.colorScheme.primary
            ) {
                Text(
                    text = "Discover a New World of Reading",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Escape into the pages of captivating stories and explore new worlds, right from your phone.",
                color = Color.White,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Row for the IconButton on the extreme right
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Button(modifier = Modifier.padding(horizontal = 20.dp), colors = ButtonDefaults.buttonColors(
                    Color.Cyan),
                    onClick = {
                        navController.navigate(ReaderScreens.SecondPageT.name)
                    },
                ) {
                    Text(text = "Tutorial", modifier = Modifier.padding(horizontal = 20.dp))
                }
                Button(modifier = Modifier.padding(horizontal = 20.dp), colors = ButtonDefaults.buttonColors(
                    Color.Cyan),
                    onClick = {
                        navController.navigate(ReaderScreens.LoginScreen.name)
                    }

                ) {
                    Text(text = "Explore Now")
                }
            }
        }
    }
}
