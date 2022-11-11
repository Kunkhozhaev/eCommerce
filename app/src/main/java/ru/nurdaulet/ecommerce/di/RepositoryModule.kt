package ru.nurdaulet.ecommerce.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.nurdaulet.ecommerce.domain.repository.detail.ProductDetailRepository
import ru.nurdaulet.ecommerce.domain.repository.detail.ProductDetailRepositoryImpl
import ru.nurdaulet.ecommerce.domain.repository.product.ProductRepository
import ru.nurdaulet.ecommerce.domain.repository.product.ProductRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindProductRepository(impl: ProductRepositoryImpl): ProductRepository

    @[Binds Singleton]
    fun bindProductDetailRepository(impl: ProductDetailRepositoryImpl): ProductDetailRepository
}