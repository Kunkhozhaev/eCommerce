package ru.nurdaulet.ecommerce.domain.repository.product

import kotlinx.coroutines.flow.Flow
import ru.nurdaulet.ecommerce.data.models.responce.product.HomeStoreData
import ru.nurdaulet.ecommerce.utils.UiState

interface ProductRepository {
    fun getProducts(): Flow<UiState<HomeStoreData>>
}