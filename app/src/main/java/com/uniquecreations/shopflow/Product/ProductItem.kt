package com.uniquecreations.shopflow.Product

data class ProductItem(
    val name: String,
    val imageRes: Int,
    val isBestSeller : Boolean,
    var isFavorite : Boolean
)