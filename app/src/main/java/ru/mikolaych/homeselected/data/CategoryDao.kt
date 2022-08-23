package ru.mikolaych.homeselected.data

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.mikolaych.homeselected.models.CategoryModel

@Dao
interface CategoryDao {

    @Insert
    suspend fun insertCategory(categoryModel: CategoryModel)

    @Update
    suspend fun updateCategory(categoryModel: CategoryModel)

    @Delete
    suspend fun deleteCategory(categoryModel: CategoryModel)

    @Query("DELETE FROM category_data_table")
    suspend fun deleteAllCategories()

    @Query("SELECT * FROM category_data_table")
    fun getAllCategories(): LiveData<List<CategoryModel>>
}