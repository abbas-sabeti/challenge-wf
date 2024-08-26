package com.example.challenge.model

import com.example.challenge.domain.model.ProductList

data class PrimaryModel(
    val products: ProductList = ProductList(),
    val failedInLoading: Boolean = false
)