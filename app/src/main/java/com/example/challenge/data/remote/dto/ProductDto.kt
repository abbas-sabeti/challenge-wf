package com.example.challenge.data.remote.dto

import com.example.challenge.domain.model.Product
import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("tagline")
    val tagline: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("rating")
    val rating: Double
)

fun ProductDto.toProduct(): Product {
    return Product(
        name = name,
        tagline = tagline,
        date = date,
        rating = rating
        )
}