package com.example.challenge.domain.usecases

import com.example.challenge.data.remote.dto.toProduct
import com.example.challenge.domain.model.ProductList
import com.example.challenge.domain.repository.ProductRepository
import javax.inject.Inject

class GetProducts @Inject constructor(
    private var repository: ProductRepository
) {
    suspend operator fun invoke(): ProductList {
        val result = repository.getProducts()
        return ProductList(items = result.map { it.toProduct() })
    }
}