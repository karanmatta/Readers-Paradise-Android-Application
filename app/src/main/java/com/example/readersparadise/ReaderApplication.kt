package com.example.readersparadise

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel

// This annotation tells Hilt that this is the Application class
// To bind dependencies to the entire app, add the @HiltAndroidApp annotation to your Application class.
// This triggers Hilt's code generation, including a base class for your application that serves as the app-level dependency container.

@HiltAndroidApp
class ReaderApplication: Application(){

}

