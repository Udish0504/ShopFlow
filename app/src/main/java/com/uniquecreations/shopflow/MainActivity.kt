package com.uniquecreations.shopflow
import SkincareShopScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.uniquecreations.shopflow.ui.theme.ShopFlowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShopFlowTheme {
                SkincareShopScreen()
            }
        }
    }
}
