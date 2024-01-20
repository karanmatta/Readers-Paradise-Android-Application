package com.example.readersparadise


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.Coil
import coil.ImageLoader
import com.example.readersparadise.navigation.ReaderNavigation
import com.example.readersparadise.ui.theme.ReadersParadiseTheme
import com.google.firebase.FirebaseApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageLoader = ImageLoader.Builder(this)
            .crossfade(true) // Add other configurations as needed
            .build()

        // Initialize Coil with the ImageLoader instance
        Coil.setImageLoader(imageLoader)

        FirebaseApp.initializeApp(this)
        setContent {
            ReadersParadiseTheme {
                // A surface container using the 'background' color from the theme

                ReaderApp()

            }
        }
    }
}

@Composable
fun ReaderApp(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 46.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally ) {
            ReaderNavigation()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ReadersParadiseTheme {
        // Greeting("Android")
    }
}