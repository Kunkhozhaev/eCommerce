package ru.nurdaulet.ecommerce.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.nurdaulet.ecommerce.R
import ru.nurdaulet.ecommerce.databinding.ContainerMainBinding

@AndroidEntryPoint
class MainContainer : Fragment(R.layout.container_main) {

    private lateinit var navController: NavController
    private val binding: ContainerMainBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(requireActivity(), R.id.container_main)
        binding.bottomNavView.setupWithNavController(navController)
    }
}