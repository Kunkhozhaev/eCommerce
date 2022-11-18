package ru.nurdaulet.ecommerce.utils

import ru.nurdaulet.ecommerce.R
import ru.nurdaulet.ecommerce.data.models.CategoryData

object Categories {

    val list = mutableListOf<CategoryData>()

    init {
        list.add(CategoryData(1, "Phones", R.drawable.phone, true))
        list.add(CategoryData(2, "Computer", R.drawable.computer, false))
        list.add(CategoryData(3, "Health", R.drawable.health, false))
        list.add(CategoryData(4, "Books", R.drawable.books, false))
        list.add(CategoryData(5, "Tools", R.drawable.phone, false))
    }
}