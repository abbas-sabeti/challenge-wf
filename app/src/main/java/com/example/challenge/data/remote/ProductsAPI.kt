package com.example.challenge.data.remote

import com.example.challenge.data.remote.dto.ProductDto
import retrofit2.http.GET

interface ProductsAPI {
    @GET("interview-sandbox/android/json-to-list/products.v1.json")
    suspend fun getTopProducts(): List<ProductDto>
}