package com.example.demokotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.demokotlin.ui.theme.DemoKotlinTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoKotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    CustomCard(CardDetails(
                        title = "iwin",
                        description = "Singam",
                        image = "https://img.freepik.com/free-photo/portrait-lion-ai-generated_268835-4278.jpg?w=1060&t=st=1703935543~exp=1703936143~hmac=8eae8ba907b0eb2359415c03fc2990fb7347d30b3191c9374e566aaac444688e"
                    ),
                        onClick = { handleClick() })
                }
            }
        }
    }
}

@Composable
fun CardContent(name: String, description: String, modifier: Modifier = Modifier) {
    Column {
        Text(text = name.uppercase())
        Text(text = description)
    }

}

fun handleClick(): Unit {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemoKotlinTheme {
        CustomCard(CardDetails(
            title = "iwin",
            description = "Singam",
            image = "https://img.freepik.com/free-photo/portrait-lion-ai-generated_268835-4278.jpg?w=1060&t=st=1703935543~exp=1703936143~hmac=8eae8ba907b0eb2359415c03fc2990fb7347d30b3191c9374e566aaac444688e"
        ),
            onClick = { handleClick() })
    }
}


class CardDetails(title: String, description: String, image: String) {
    val title: String = title
    val image: String = image
    val description: String = description
}

@Composable
fun CustomCard(data: CardDetails, onClick: () -> Unit) {

    Box(modifier = Modifier.padding(10.dp)) {
        Column(
            modifier = Modifier
                .clickable(onClick = onClick)
                .height(300.dp)
                .fillMaxWidth()
                .border(0.2.dp, Color.Blue, shape = MaterialTheme.shapes.small)
        ) {
            Row(modifier = Modifier.padding(10.dp)) {
                CardContent(name = data.title, description = data.description)
            }
            AsyncImage(
                model = data.image,
                contentDescription = data.title,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            )
        }
    }
}