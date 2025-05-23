package com.uniquecreations.shopflow.Appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniquecreations.shopflow.ui.theme.CarouselTheme

@Composable
fun ShopTopBar() {
    Row(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .height(65.dp)
            .background(CarouselTheme.DarkBackground),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.White,
            modifier = Modifier.size(40.dp).padding(start = 16.dp)
        )

        Text(
            text = "Shop",
            color = Color.White,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )

        IconButton(onClick = { /* TODO */ }) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
        }

        BadgedBox(
            badge = {
                Badge(
                    containerColor = Color(0xFF9CFF5C),
                    contentColor = Color.Black,
                    modifier = Modifier.offset(x = (-15).dp, y = 6.dp)
                ) {
                    Text(text = "5")
                }
            }
        ) {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "Cart",
                tint = Color.White,
                modifier = Modifier.size(50.dp).padding(end = 16.dp)
            )
        }

        BadgedBox(
            badge = {
                Badge(
                    containerColor = Color(0xFF9CFF5C),
                    contentColor = Color.Black,
                    modifier = Modifier.offset(x = (-6).dp, y = 6.dp)
                ) {
                    Text(text = "3")
                }
            }
        ) {
            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = "Cart",
                tint = Color.White,
                modifier = Modifier.size(50.dp).padding(end = 16.dp)
            )
        }
    }
}