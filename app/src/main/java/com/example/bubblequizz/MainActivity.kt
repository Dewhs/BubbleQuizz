package com.example.bubblequizz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bubblequizz.View.theme.CustomTheme
import com.example.bubblequizz.View.theme.Heading1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomTheme {
                Row(
                    modifier = Modifier.fillMaxSize(),

                    ) {
                    Greeting("Android")
                }
            }
            /* BubbleQuizzTheme {
                 // A surface container using the 'background' color from the theme
                 Row(
                     modifier = Modifier.fillMaxSize(),

                 ) {
                     Greeting("Android")
                 }
             }*/
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    BasicText(

        text = "Hello $name!",
        modifier = modifier,
        style = CustomTheme.typography.Heading1
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    /*BubbleQuizzTheme {
        Greeting("Android")
    }*/
}