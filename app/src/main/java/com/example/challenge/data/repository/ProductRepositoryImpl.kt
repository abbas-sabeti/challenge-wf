package com.example.challenge.data.repository

import com.example.challenge.data.remote.ProductsAPI
import com.example.challenge.data.remote.dto.ProductDto
import com.example.challenge.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductsAPI
): ProductRepository
{
    override suspend fun getProducts(): List<ProductDto> {
        return api.getTopProducts();
    }
}