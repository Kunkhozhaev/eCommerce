package ru.nurdaulet.ecommerce.domain.usecases.product

import kotlinx.coroutines.flow.Flow
import ru.nurdaulet.ecommerce.data.models.responce.product.HomeStoreData
import ru.nurdaulet.ecommerce.utils.UiState

interface ProductUseCase {
    fun getProducts(): Flow<UiState<HomeStoreData>>
}