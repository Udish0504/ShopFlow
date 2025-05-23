package com.uniquecreations.shopflow.Carousel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.uniquecreations.shopflow.ui.theme.CarouselTheme

@Composable
fun PageIndicators(
    pagerState: androidx.compose.foundation.pager.PagerState,
    itemCount: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(itemCount) { index ->
            val isActive = pagerState.currentPage == index
            Box(
                modifier = Modifier
                    .size(width = 24.dp, height = 8.dp)
                    .clip(CircleShape)
                    .background(
                        if (isActive) CarouselTheme.IndicatorActive
                        else Color.Black
                    )
            )
        }
    }
}