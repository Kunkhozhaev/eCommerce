package ru.nurdaulet.ecommerce.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.nurdaulet.ecommerce.domain.usecases.detail.ProductDetailUseCase
import ru.nurdaulet.ecommerce.domain.usecases.detail.ProductDetailUseCaseImpl
import ru.nurdaulet.ecommerce.domain.usecases.product.ProductUseCase
import ru.nurdaulet.ecommerce.domain.usecases.product.ProductUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindProductUseCase(impl: ProductUseCaseImpl): ProductUseCase

    @Binds
    fun bindProductDetailUseCase(impl: ProductDetailUseCaseImpl): ProductDetailUseCase
}