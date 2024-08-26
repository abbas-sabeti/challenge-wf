package com.example.challenge.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challenge.domain.model.ProductList
import com.example.challenge.ui.theme.ChallengeTheme
import kotlin.math.roundToInt

@Composable
fun PrimaryScreen(products: ProductList) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Products"
        )
        Spacer(modifier = Modifier.height(24.dp))
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(products.items) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            1.dp,
                            Color.Black,
                            shape = RoundedCornerShape(corner = CornerSize(16.dp))
                        )
                        .padding(8.dp)
                ) {
                    Column {
                        Text(text = it.name, fontWeight = FontWeight.Bold)
                        Text(text = it.tagline)
                        Text(text = it.date)
                        Text(text = it.rating.roundToNearestHalf().toString())
                    }
                }

            }
        }
    }
}

@Preview
@Composable
fun PrimaryScreenPreview(modifier: Modifier = Modifier) {
    ChallengeTheme{
        PrimaryScreen(products = ProductList())
    }
}

private fun Double.roundToNearestHalf(): Double {
    return (this * 2).roundToInt().toDouble() / 2
}
