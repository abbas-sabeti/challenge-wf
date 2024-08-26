package com.example.challenge

import com.example.challenge.data.remote.ProductsAPI
import com.example.challenge.data.repository.ProductRepositoryImpl
import com.example.challenge.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun providesRetrofitApi(): ProductsAPI {
        return Retrofit
            .Builder()
            .baseUrl("https://api.wayfair.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductsAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideProductsRepository(repo: ProductRepositoryImpl): ProductRepository {
        return repo
    }

}