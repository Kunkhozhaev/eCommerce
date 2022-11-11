package ru.nurdaulet.ecommerce.domain.usecases.detail

import kotlinx.coroutines.flow.Flow
import ru.nurdaulet.ecommerce.data.models.responce.detail.ProductDetailData
import ru.nurdaulet.ecommerce.utils.UiState

interface ProductDetailUseCase {
    fun getProductDetail(): Flow<UiState<ProductDetailData>>
}