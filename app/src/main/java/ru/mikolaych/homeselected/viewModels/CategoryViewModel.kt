package ru.mikolaych.homeselected.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.mikolaych.homeselected.models.CategoryModel
import ru.mikolaych.homeselected.repositories.CategoryRepository

class CategoryViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {

    val categories = categoryRepository.categories

    fun startInsert(nameCategories:String) {
        insert(CategoryModel(0, nameCategories))
    }

    fun startUpdateProduct(idCategories:Int, nameCategories:String) {
        updateProduct(CategoryModel(idCategories, nameCategories))
    }

    private fun insert(categoryModel: CategoryModel) = viewModelScope.launch{

        categoryRepository.insertCategory(categoryModel)
    }

    private fun updateProduct(categoryModel: CategoryModel) = viewModelScope.launch{

        categoryRepository.updateCategory(categoryModel)
    }

    fun delete(categoryModel: CategoryModel) = viewModelScope.launch{

        categoryRepository.deleteCategory(categoryModel)
    }

    fun deleteAll() = viewModelScope.launch{

        categoryRepository.deleteAllCategories()
    }

}