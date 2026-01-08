package com.example.selfcode.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.selfcode.ui.theme.Black
import com.example.selfcode.model.QuoteViewModel
import com.example.selfcode.ui.theme.Gray

@Composable
fun QuotesScreen(viewModel: QuoteViewModel){

    val quote = viewModel.quote

    Box(modifier = Modifier.fillMaxSize()) {

            Text(
                text = "Life Quotes ",
                modifier = Modifier
                    .align (Alignment.TopCenter)
                    .padding(top = 50.dp),
                color = Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

        Spacer(modifier = Modifier.fillMaxSize(1f))

        Column(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {

            if (quote == null) {

                Text(
                    "Loading...",
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Italic
                )
            } else {

                Text("“${quote.q}”",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    "- ${quote.a}",
                    fontStyle = FontStyle.Italic
                )
            }

            Spacer(modifier = Modifier.padding(25.dp))

            QuoteButton(
                "Next Quotes",
                modifier = Modifier.background(color = Gray)
                    .align(Alignment.CenterHorizontally),
                onClick = {
                    viewModel.fetchQuote()
                }
            )
        }
    }
}

@Composable
fun QuoteButton(
    symbol: String,
    modifier: Modifier,
    onClick :()-> Unit
) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.clip(RoundedCornerShape(18.dp))
            .clickable{ onClick() }
            .then(modifier)
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = symbol,
            fontSize = 16.sp,
            color = androidx.compose.ui.graphics.Color.White
        )
    }
}

