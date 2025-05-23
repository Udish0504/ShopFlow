import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.uniquecreations.shopflow.Carousel.carouselItems
import com.uniquecreations.shopflow.Category.CategorySection
import com.uniquecreations.shopflow.Product.NewProductsHeader
import com.uniquecreations.shopflow.Product.ProductCard
import com.uniquecreations.shopflow.Product.ProductItem
import com.uniquecreations.shopflow.R
import com.uniquecreations.shopflow.Appbar.ShopTopBar
import com.uniquecreations.shopflow.ui.theme.CarouselTheme

@Composable
fun SkincareShopScreen() {
    val systemUiController = rememberSystemUiController()
    val backgroundColor = CarouselTheme.DarkBackground
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = backgroundColor,
            darkIcons = false
        )
    }
    val categories = listOf("Cleansers", "Toner", "Serums", "Moisturizers", "Sunscreen")

    val products = listOf(
        ProductItem(
            name = "clencera",
            imageRes = R.drawable.productimage,
            isBestSeller = true,
            isFavorite = true
        ),
        ProductItem(
            name = "glow",
            imageRes = R.drawable.categorysample,
            isBestSeller = false,
            isFavorite = false
        )
    )

    Scaffold(
        topBar = {
            ShopTopBar()
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(CarouselTheme.DarkBackground)
        ) {
            item {
                CarouselUI(carouselItems = carouselItems)
            }

            item {
                CategorySection(categories)
            }

            item {
                NewProductsHeader()
            }

            items(products) { product ->
                ProductCard(product)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}












