package com.example.challenge.domain.repository

import com.example.challenge.data.remote.dto.ProductDto

interface ProductRepository {
    suspend fun getProducts(): List<ProductDto>
}