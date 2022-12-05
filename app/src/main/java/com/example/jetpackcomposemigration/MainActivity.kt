package com.example.jetpackcomposemigration

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Guarda en una variable la vista ComposeView

        val helloCompose = findViewById<ComposeView>(R.id.helloCompose)
        helloCompose.setContent {
            //Hello()
            LoginScreen()
        }

    }
}

@Composable
fun LoginScreen() {
    val context = LocalContext.current
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
    ) {
        OutlinedTextField(
            value = username,
            placeholder = { Text(text = "user@email.com") },
            label = { Text(text = "Username") },
            onValueChange = { username = it }
        )
        OutlinedTextField(
            value = password,
            placeholder = { Text(text = "password") },
            label = { Text(text = "Password") },
            onValueChange = { password = it }
        )

        Button(
            onClick = {
                if (username.isEmpty() || password.isEmpty() ){
                    Toast.makeText(context,"Rellena los datos",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context,"Login Correcto",Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text(text = "Login")
        }
    }
}

@Composable
fun Hello() {
    Column() {
        Text(
            "Hello Jetpack Compose",
            modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHello() {
    //Hello()
    LoginScreen()
}
