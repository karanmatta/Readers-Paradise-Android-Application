package com.example.readersparadise.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.readersparadise.components.ReaderAppBar
import com.example.readersparadise.components.RoundedButton
import com.example.readersparadise.model.MBook
import com.example.readersparadise.navigation.ReaderScreens
import com.google.firebase.auth.FirebaseAuth


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(navController: NavController) {

    Scaffold(topBar = {
        ReaderAppBar(title = "Reader's Paradise", navController = navController)
    },
        floatingActionButton = {
            FABContent (onTap = {}, navController = navController)
        }) {
        Surface(modifier = Modifier.fillMaxSize()) {

            //Home Content

            HomeContent(navController)
        }
    }
}

@Composable
fun HomeContent(navController: NavController){

    val listOfBooks = listOf(
        MBook(id="A",title = "Kotlin", author = "All of Us",notes = null),
        MBook(id="B",title = "Jetpack", author = "All of Us",notes = null),
        MBook(id="C",title = "SDK", author = "All of Us",notes = null),
        MBook(id="D",title = "Java", author = "All of Us",notes = null),
        MBook(id="E",title = "UI/UX", author = "All of Us",notes = null),

    )



    // me @gmail.com
    val currentUserName = if (!FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty())
        FirebaseAuth.getInstance().currentUser?.email?.split("@")?.get(0)
    else "N/A"



    Column(modifier = Modifier.padding(2.dp),
        verticalArrangement = Arrangement.Top) {
        
        
        Spacer(modifier = Modifier.height(50.dp))

        Row(modifier = Modifier.align(alignment=Alignment.Start)){

            TitleSection(label = "Reading Right Now \n" + "activity right now")
            Spacer(modifier = Modifier.fillMaxWidth(0.7f))

            Column {
                Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "Profile",
                    modifier = Modifier
                        .clickable {
                            navController.navigate(ReaderScreens.ReaderStatsScreen.name)
                        }
                        .size(45.dp),
                    tint = MaterialTheme.colorScheme.secondary)

                Text(text = currentUserName!!,
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color= Color.Red,
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Clip)
                HorizontalDivider()


            }
            
            
            
//            Spacer(modifier = Modifier.width(100.dp))
//            TitleSection(label = "Want to Read")

        }



       ReadingRightNowArea(books = listOf(), navController = navController)
        
        TitleSection(label = "Reading List")

        BookListArea(listOfBooks = listOfBooks,navController=navController)

    }

}

@Composable
fun BookListArea(listOfBooks: List<MBook>,
                 navController: NavController) {


    HorizontalScrollableComponent(listOfBooks){



        //ToDo: On Card Clicked Go to Details
    }

}

@Composable
fun HorizontalScrollableComponent(listOfBooks: List<MBook>,onCardPress: (String) -> Unit ) {

    val scrollState = rememberScrollState()

    Row(modifier = Modifier
        .fillMaxWidth()
        .heightIn(280.dp)
        .horizontalScroll(scrollState)){

        for (book in listOfBooks){
            ListCard(book){

                 onCardPress(it)
            }
        }

    }

}


@Preview
@Composable
fun ListCard(
    book: MBook = MBook("af", "running", "Me and You", "Hello World"),
    onPressDetails: (String) -> Unit = {}
) {

    val context = LocalContext.current
    val resources=context.resources
    val displayMetrics = resources.displayMetrics
    val screenWidth = displayMetrics.widthPixels / displayMetrics.density
    val spacing = 10.dp

    Card(shape= RoundedCornerShape(29.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp ),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .padding(16.dp)
            .height(242.dp)
            .width(202.dp)
            .height(202.dp)
            .clickable { onPressDetails.invoke(book.title.toString()) },

        ) {

            Column(modifier = Modifier.width(screenWidth.dp - (spacing * 2)) ,
                horizontalAlignment = Alignment.Start) {

                Row (horizontalArrangement = Arrangement.Center){

                    Image(painter = rememberImagePainter(data = "https://books.google.com/books?id=zyTCAlFPjgYC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"), contentDescription = "Book Image",
                        modifier = Modifier
                            .height(140.dp)
                            .width(100.dp)
                            .padding(4.dp))

                    Spacer(modifier = Modifier.width(50.dp))

                    Column(modifier = Modifier.padding(top = 25.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(imageVector = Icons.Rounded.FavoriteBorder, contentDescription ="Fav Icon",
                            modifier = Modifier.padding(bottom = 1.dp))



                        BookRating(score = 3.5)

                    }

                }

                Text(text = book.title.toString(), modifier = Modifier.padding(4.dp),
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis)

                Text(
                    text = book.author.toString(),
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodySmall
                )
                Row (horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier.fillMaxWidth()){

                    Spacer(modifier = Modifier.weight(1f))
                    RoundedButton(label = "Reading",radius=70)

                }

            }


    }
}

@Composable
fun BookRating(score: Double = 4.5) {

    Surface(modifier = Modifier
        .height(70.dp)
        .padding(4.dp),
        shape = RoundedCornerShape(56.dp),
        shadowElevation = 6.dp,
        color = Color.White
    ) {
        Column (modifier = Modifier.padding(4.dp)){


            Icon(
                imageVector = Icons.Filled.StarBorder, contentDescription = "Star",
                modifier = Modifier.padding(3.dp)
            )

            Text(text = score.toString(), style = MaterialTheme.typography.bodyLarge)

        }
    }

}







@Composable
fun TitleSection(modifier: Modifier = Modifier, label:String){
    Surface(modifier = modifier.padding(start = 5.dp , top = 1.dp)) {
        Column {
            Text(
                text = label,
                fontSize = 19.sp, // Adjust the size according to your needs
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Left

            )
        }
    }
}





@Composable
fun ReadingRightNowArea(books : List<MBook>, navController: NavController){

ListCard()



}



@Composable
fun FABContent(onTap: (String) -> Unit,navController: NavController){

    FloatingActionButton(onClick = {onTap("") }, shape = RoundedCornerShape(50.dp),
        containerColor = Color(0xFF92CBDF)
    ) {

        Icon(imageVector = Icons.Default.Add, contentDescription ="Add a Book" , tint = Color.White,
            modifier = Modifier.clickable {
                navController.navigate(ReaderScreens.SearchScreen.name) // Trigger navigation
            }

        )
//
//        Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "Profile",
//            modifier = Modifier
//                .clickable {
//                    navController.navigate(ReaderScreens.ReaderStatsScreen.name)
//                }
//                .size(45.dp),
//



    }

}



