package ru.nurdaulet.ecommerce.presentation.main.explorer

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import ru.nurdaulet.ecommerce.R
import ru.nurdaulet.ecommerce.data.models.CategoryData
import ru.nurdaulet.ecommerce.databinding.ScreenExplorerBinding
import ru.nurdaulet.ecommerce.presentation.BottomFilterSheet
import ru.nurdaulet.ecommerce.utils.Categories
import ru.nurdaulet.ecommerce.utils.UiState
import ru.nurdaulet.ecommerce.utils.extenions.onClick
import ru.nurdaulet.ecommerce.utils.extenions.showMessage

@AndroidEntryPoint
class ExplorerScreen : Fragment(R.layout.screen_explorer) {

    private val binding: ScreenExplorerBinding by viewBinding()
    private val categoryAdapter by lazy(LazyThreadSafetyMode.NONE) { CategoryAdapter() }
    private val hotSalesAdapter by lazy(LazyThreadSafetyMode.NONE) { HotSalesAdapter() }
    private val bestSellerAdapter by lazy(LazyThreadSafetyMode.NONE) { BestSellerAdapter() }
    private val navController by lazy(LazyThreadSafetyMode.NONE) { findNavController() }
    private val viewModel: ProductViewModel by viewModels()

    private lateinit var dialogFilter: BottomSheetDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterSetup()
        viewModel.getProducts()
        setupObserver()
    }

    private fun adapterSetup() {
        binding.apply {
            rvCategories.adapter = categoryAdapter
            rvHotSales.adapter = hotSalesAdapter
            rvBestSeller.adapter = bestSellerAdapter
            categoryAdapter.submitList(Categories.list)
        }
        categoryAdapter.setOnItemCategorySelectListener {
            val list = mutableListOf<CategoryData>()
            // TODO
        }

        binding.filterButton.onClick {
            val bottomSheet = BottomFilterSheet()
            bottomSheet.show(childFragmentManager, "BOTTOM_SHEET")
        }
    }

    private fun setupObserver() {
        lifecycleScope.launchWhenResumed {
            viewModel.products.collect {
                when (it) {
                    is UiState.Loading -> {
                        loading(true)
                    }
                    is UiState.NetworkError -> {
                        loading(false)
                        showMessage(it.msg!!)
                    }
                    is UiState.Error -> {
                        loading(false)
                        showMessage(it.msg!!)
                    }
                    is UiState.Success -> {
                        loading(false)
                        hotSalesAdapter.submitList(it.data.home_store)
                        bestSellerAdapter.submitList(it.data.best_seller)
                    }
                    else -> {
                        loading(false)
                    }
                }
            }
        }
    }

    private fun loading(b: Boolean) {
        binding.progressBar.isVisible = b
    }
}