package com.example.bubblequizz.ui.theme


import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.bubblequizz.View.theme.Heading1
import com.example.bubblequizz.View.theme.Heading2
import com.example.bubblequizz.View.theme.Heading3
import com.example.bubblequizz.View.theme.LightColor
import com.example.bubblequizz.Model.Categories
import kotlin.math.roundToInt

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
                    category = Categories.entries[it]
                )
            }
        }
    }
}


@Composable
fun CategoryCard(category: Categories) {
    var expandedState by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(bottom = 15.dp)
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(30.dp))
            .clickable {
                expandedState = !expandedState
                println("${category.apiName} Click !")
            }
            .padding(25.dp)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = EaseInOut
                )
            ),
        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = category.iconLocation), contentDescription = null)
            BasicText(
                modifier = Modifier
                    .padding(start = 15.dp, top = 3.dp),
                text = category.apiName,
                style = Heading2
            )
        }
        if (expandedState) {
            ScoreContainer()
        }
    }
}

@Composable
fun ScoreContainer() {
    Column(
        modifier = Modifier
            .padding(horizontal = 25.dp, vertical = 15.dp)

    ) {
        Box(
            Modifier
                .padding(bottom = 15.dp)
                .height(2.dp)
                .fillMaxWidth()
                .background(LightColor, shape = DottedShape(step = 15.dp))
        )

        ScoreLine(username = "User1", score = 2564, textStyle = Heading2)
        ScoreLine(username = "User2", score = 15, textStyle = Heading3)
        ScoreLine(username = "User3", score = 14, textStyle = Heading3)


    }
}

@Composable
fun ScoreLine(username: String, score: Int, textStyle: TextStyle)
{
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BasicText(
            text = username,
            style = textStyle,
        )
        BasicText(
            text = "$score pts",
            style = textStyle
        )
    }
}





//To check optimisation
private data class DottedShape(
    val step: Dp,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ) = Outline.Generic(Path().apply {
        val stepPx = with(density) { step.toPx() }
        val stepsCount = (size.width / stepPx).roundToInt()
        val actualStep = size.width / stepsCount
        val dotSize = Size(width = actualStep / 2, height = size.height)
        for (i in 0 until stepsCount) {
            addRect(
                Rect(
                    offset = Offset(x = i * actualStep, y = 0f),
                    size = dotSize
                )
            )
        }
        close()
    })
}