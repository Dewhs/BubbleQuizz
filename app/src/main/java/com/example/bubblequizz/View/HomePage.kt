package com.example.bubblequizz.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.overscroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bubblequizz.R
import com.example.bubblequizz.View.theme.Heading1
import com.example.bubblequizz.View.theme.Heading2
import com.example.bubblequizz.View.theme.Heading3
import com.example.bubblequizz.View.theme.LightColor
import com.example.bubblequizz.View.theme.PrimaryColor
import com.example.bubblequizz.View.theme.RedColor
import java.util.Locale.Category
import com.example.bubblequizz.Model.Categories

@Preview
@Composable
fun HomePage(

) {

    /* Global container */
    Column(
        modifier = Modifier
            .background(LightColor)
            .padding(top = 25.dp, start = 25.dp, end = 25.dp)
            .fillMaxSize()

    ) {
        /* Title container */
        Row(
            modifier = Modifier.padding(bottom = 25.dp)
        ) {
            Column {
                BasicText(
                    style = Heading1,
                    text = "BubbleQuizz"
                )
                BasicText(
                    text = "Open source educative app based on open trivia database.",
                    style = Heading3
                )
                /*BasicText(modifier = Modifier, text = "open trivia database", style = Heading3.copy(color = PrimaryColor))*/
            }


        }
        /* ScrollListView container */
        LazyColumn {
            items(
                count = Categories.entries.size
            ) {
                CategoryCard(
                    name = Categories.entries[it].apiName,
                    iconLocation = Categories.entries[it].iconLocation
                )
            }
        }
    }
}



@Composable
fun CategoryCard(name: String, iconLocation: Int) {
    Row(
        modifier = Modifier
            .padding(bottom = 15.dp)
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(30.dp))
            .padding(25.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(painter = painterResource(id = iconLocation), contentDescription = null)
        BasicText(
            modifier = Modifier
                .padding(start = 15.dp, top = 3.dp),
            text = name,
            style = Heading2
        )
    }
}