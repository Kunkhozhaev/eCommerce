package ru.nurdaulet.ecommerce.domain.usecases.product

import kotlinx.coroutines.flow.Flow
import ru.nurdaulet.ecommerce.data.models.responce.product.HomeStoreData
import ru.nurdaulet.ecommerce.domain.repository.product.ProductRepository
import ru.nurdaulet.ecommerce.utils.UiState
import javax.inject.Inject

class ProductUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
): ProductUseCase {
    override fun getProducts(): Flow<UiState<HomeStoreData>> {
        return productRepository.getProducts()
    }
}