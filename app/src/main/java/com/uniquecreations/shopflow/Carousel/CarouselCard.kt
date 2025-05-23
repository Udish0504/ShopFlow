import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniquecreations.shopflow.Carousel.CarouselItem
import com.uniquecreations.shopflow.Carousel.PageIndicators
import com.uniquecreations.shopflow.R
import com.uniquecreations.shopflow.ui.theme.CarouselTheme




@Composable
fun CarouselUI(carouselItems: List<CarouselItem>) {
    val pagerState = rememberPagerState(initialPage = 0) {
        carouselItems.size
    }

    val currentItem = carouselItems[pagerState.currentPage]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CarouselTheme.DarkBackground)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .background(CarouselTheme.DarkBackground)
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                Image(
                    painter = painterResource(id = carouselItems[page].imageResId),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize(),
                    colorFilter = ColorFilter.tint(Color.Black, blendMode = BlendMode.SrcIn)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(CarouselTheme.DarkBackground.copy(alpha = 0f))
                    .padding(start = 45.dp)
            ) {
                Column(
                    modifier = Modifier.align(Alignment.CenterStart),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = currentItem.title,
                        color = Color.White,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = currentItem.subtitle,
                        color = Color.White,
                        fontSize = 16.sp
                    )
                    Row (horizontalArrangement = Arrangement.spacedBy(80.dp)) {
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = CarouselTheme.IndicatorActive,
                        modifier = Modifier.height(28.dp)
                    ) {
                        Text(
                            text = currentItem.dateRange,
                            color = Color.Black,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(horizontal = 16.dp,vertical = 2.dp).align(Alignment.CenterVertically)
                        )
                    }
                        Image(painter = painterResource(id = R.drawable.image),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(start = 8.dp)
                                .align(Alignment.CenterVertically),
                            colorFilter = ColorFilter.tint(Color.White, blendMode = BlendMode.SrcIn)
                        )


                    }
                }
            }
            PageIndicators(
                pagerState = pagerState,
                itemCount = carouselItems.size,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(top = 10.dp, start = 60.dp, bottom = 4.dp)
            )
        }
    }
}

