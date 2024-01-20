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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.readersparadise.navigation.ReaderScreens

@Composable
fun SecondPage(navController: NavController) {
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
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.primary
            ) {

            }
            Spacer(modifier = Modifier.height(8.dp))

            Spacer(modifier = Modifier.height(16.dp))

            // Row for the IconButton on the extreme right
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.End
            ) {


                IconButton(
                    onClick = {
                        navController.navigate(ReaderScreens.SecondPageT.name)
                    },
                ) {
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
                }

            }
        }
    }
}




