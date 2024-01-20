package com.example.readersparadise.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.readersparadise.navigation.ReaderScreens
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ReaderLogo(modifier: Modifier = Modifier) {
    Text(
        text = "Reader's Paradise",
        modifier=modifier.padding(bottom = 16.dp),
        style = MaterialTheme.typography.displaySmall,
        color = Color.Red.copy(alpha = 0.5f)
    )
}

@Composable
fun EmailInput(
    modifier: Modifier = Modifier,
    emailState: MutableState<String>,
    labelId: String= "Email",
    enabled: Boolean = true,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,

    ){
    InputField(modifier = Modifier,
        valueState = emailState,
        labelId = labelId,
        enabled = enabled,
        keyboardType = KeyboardType.Email,
        imeAction = imeAction,
        onAction = onAction
    )

}

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    labelId: String,
    enabled: Boolean,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default )
{
    OutlinedTextField(value = valueState.value, onValueChange = {
        valueState.value=it },
        label = { Text(text =labelId)},
        singleLine = isSingleLine,
        textStyle = TextStyle(fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground),
        modifier = Modifier.padding(bottom = 10.dp, start = 10.dp, end =10.dp).fillMaxWidth(),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),


        )
}


@Composable
fun PasswordInput(
    modifier: Modifier,
    passwordState: MutableState<String>,
    labelId: String,
    enabled: Boolean,
    passwordVisibility: MutableState<Boolean>,
    imeAction: ImeAction = ImeAction.Done,
    onAction: KeyboardActions = KeyboardActions.Default,

    ) {

    val visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation()

    OutlinedTextField(value = passwordState.value, onValueChange = {
        passwordState.value=it
    } ,
        label = { Text(text =labelId)},
        singleLine = true,
        textStyle = TextStyle(fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground),
        modifier = modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        enabled = enabled,

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,imeAction = imeAction),
        visualTransformation = visualTransformation,
        trailingIcon={ PasswordVisibility(passwordVisibility = passwordVisibility) }

        ,keyboardActions = onAction
    )


}
@Composable
fun PasswordVisibility(passwordVisibility: MutableState<Boolean>) {

    val visible =passwordVisibility.value
    IconButton(onClick = { passwordVisibility.value = !visible }) {

        Icons.Default.Close

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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReaderAppBar(
    title:String,
    showProfile:Boolean = true,
    navController: NavController
){
    TopAppBar(title={
        Row (verticalAlignment = Alignment.CenterVertically){

            if(showProfile){
                //            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "icon")
                Icon(imageVector = Icons.Default.Book, contentDescription = "logo Icon",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .scale(0.9f))
            }
            Text(text = title,
                color= Color.Red.copy(alpha = 0.7f),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp))
            Spacer(modifier = Modifier.width(150.dp))


        }
    },
        actions={
            IconButton(onClick = {
                FirebaseAuth.getInstance().signOut()
                navController.navigate(ReaderScreens.LoginScreen.name)
            }) {

                Icon(imageVector = Icons.Filled.Logout , contentDescription = "Logout",
                    tint = Color.Green.copy(0.4f),)

            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Transparent ),
        modifier = Modifier.shadow(elevation = 0.dp))
}





@Preview
@Composable
fun RoundedButton(
    label: String = "Reading",
    radius: Int=29,
    onPress : () -> Unit ={}
){

    Surface(modifier = Modifier.clip(RoundedCornerShape(
        bottomEndPercent = radius,
        topStartPercent = radius
    )),color = Color(0xFF92CBDF)) {

        Column (modifier = Modifier
            .width(90.dp)
            .heightIn(40.dp)
            .clickable { onPress.invoke() },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = label, style = TextStyle(color = Color.White, fontSize = 15.sp))


        }

    }

}




