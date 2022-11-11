package ru.nurdaulet.ecommerce.domain.usecases.detail

import kotlinx.coroutines.flow.Flow
import ru.nurdaulet.ecommerce.data.models.responce.detail.ProductDetailData
import ru.nurdaulet.ecommerce.domain.repository.detail.ProductDetailRepository
import ru.nurdaulet.ecommerce.utils.UiState
import javax.inject.Inject

class ProductDetailUseCaseImpl @Inject constructor(
    private val productDetailRepository: ProductDetailRepository
): ProductDetailUseCase {
    override fun getProductDetail(): Flow<UiState<ProductDetailData>> {
        return productDetailRepository.getProductDetail()
    }
}