package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.theme.PracticeTheme

class Article : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           PracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(message = stringResource(R.string.first_paragraph),
                        from = stringResource(
                        R.string.second_paragraph
                    )
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    // Create a column so that texts don't overlap
    Column(
              modifier = modifier
    ) {
        Text(
            text = message,
            fontWeight = Bold,
            fontSize = 25.sp,
            lineHeight = 60.sp,
            modifier = Modifier
                .padding(10.dp),
            textAlign = TextAlign.Justify

        )
        Text(
            text = from,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify

        )
        Text(
            text = stringResource(id = R.string.second_paragraph),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {

    val image = painterResource(id = R.drawable.bg_compose_background)

    Column {

        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.height(100.dp)

        )
        GreetingText(
            message = message,
            from = from,

        )
    }

}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    PracticeTheme {
        GreetingImage(message = stringResource(R.string.jetpack_compose_tutorial),
            from = stringResource(
            R.string.first_paragraph
        ))
    }
}