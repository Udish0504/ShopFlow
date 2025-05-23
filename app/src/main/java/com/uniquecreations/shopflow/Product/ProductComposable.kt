package com.uniquecreations.shopflow.Product

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.*
import com.uniquecreations.shopflow.R
import com.uniquecreations.shopflow.ui.theme.CarouselTheme

@Composable
fun ProductCard(productItem: ProductItem) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val customFont = FontFamily(
        Font(R.font.tangerine),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(25.dp))
            .statusBarsPadding()
            .background(CarouselTheme.DarkBackground)
    ) {
        Image(
            painter = painterResource(id = R.drawable.grey_card_svg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = { productItem.isFavorite = !productItem.isFavorite },
                    modifier = Modifier
                        .size(screenWidth * 0.08f)
                        .background(CarouselTheme.DarkBackground, shape = CircleShape)
                ) {
                    Icon(
                        imageVector = if (productItem.isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = if (productItem.isFavorite) Color(0xFFBB86FC) else Color.Gray,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                if (productItem.isBestSeller) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(100.dp))
                            .background(Color.Black)
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            "Best seller",
                            fontSize = 12.sp,
                            color = CarouselTheme.IndicatorActive,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }

            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = productItem.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.5f)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.8f)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.card_black_shape),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    colorFilter = ColorFilter.tint(Color(0xFF1A1818), blendMode = BlendMode.SrcIn),
                    modifier = Modifier.fillMaxSize()
                )
                Column(
                    modifier = Modifier
                        .padding(top = 14.dp, start = 16.dp, end = 16.dp, bottom = 16.dp) // shifted down
                        .fillMaxSize()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = productItem.name,
                            fontSize = 30.sp,
                            fontFamily = customFont,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFB6FF4D)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .background(Color(0xFF66FF00), shape = CircleShape)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "In stock",
                                color = Color(0xFFB6FF4D),
                                fontSize = 12.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "French clay and algae-powered cleanser",
                        color = Color.White,
                        fontSize = 15.sp
                    )

                    Text(
                        text = "Skin Tightness • Dry & Dehydrated Skin",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "RS. 355.20",
                            color = Color(0xFFBB86FC),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "RS. 444.00",
                            color = Color.Gray,
                            textDecoration = TextDecoration.LineThrough,
                            fontSize = 15.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        repeat(5) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Star",
                                tint = Color(0xFFFFD700),
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "249 reviews",
                            color = Color.White,
                            fontSize = 16.sp,
                            textDecoration = TextDecoration.Underline
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(start = 28.dp, top = 12.dp,bottom = 12.dp)
                        .size(65.dp) // Increased cart container size
                        .clip(CircleShape)
                        .background(Color.Transparent)
                        .border(2.dp, Color(0xFFB6FF4D), shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Cart",
                        modifier = Modifier.size(30.dp), // Increased icon size
                        tint = Color(0xFFB6FF4D)
                    )
                }
            }
        }
    }
}
