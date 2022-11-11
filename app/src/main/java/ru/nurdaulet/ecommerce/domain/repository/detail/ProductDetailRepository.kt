package ru.nurdaulet.ecommerce.domain.repository.detail

import kotlinx.coroutines.flow.Flow
import ru.nurdaulet.ecommerce.data.models.responce.detail.ProductDetailData
import ru.nurdaulet.ecommerce.utils.UiState

interface ProductDetailRepository {
    fun getProductDetail(): Flow<UiState<ProductDetailData>>
}