package com.example.readersparadise.navigation

enum class ReaderScreens {
    SplashScreen,
    LoginScreen,
    CreateAccountScreen,
    ReaderHomeScreen,
    SearchScreen,
    DetailsScreen,
    UpdateScreen,
    BookDetails,
    GraphicScreen,
    FirstPageT,
    SecondPageT,
    ReaderStatsScreen;
    companion object{
        fun fromRoute(route: String?): ReaderScreens =
            when (route?.substringBefore("/")) {
                SplashScreen.name -> SplashScreen
                LoginScreen.name -> LoginScreen
                CreateAccountScreen.name -> CreateAccountScreen
                ReaderHomeScreen.name -> ReaderHomeScreen
                SearchScreen.name -> SearchScreen
                DetailsScreen.name -> DetailsScreen
                UpdateScreen.name -> UpdateScreen
                GraphicScreen.name -> GraphicScreen
                FirstPageT.name -> FirstPageT
                SecondPageT.name -> SecondPageT
                ReaderStatsScreen.name -> ReaderStatsScreen
                BookDetails.name -> BookDetails
                null -> ReaderHomeScreen
                else -> throw IllegalArgumentException("Route $route is not recognized.")

            }
    }
}