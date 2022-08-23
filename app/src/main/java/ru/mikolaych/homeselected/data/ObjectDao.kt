package ru.mikolaych.homeselected.data

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.mikolaych.homeselected.models.ObjectModel

@Dao
interface ObjectDao {

    @Insert
    suspend fun insertObject(productModel: ObjectModel)

    @Update
    suspend fun updateObject(productModel: ObjectModel)

    @Delete
    suspend fun deleteObject(productModel: ObjectModel)

    @Query("DELETE FROM object_data_table")
    suspend fun deleteAllObjects()

    @Query("SELECT * FROM object_data_table")
    fun getAllObjects(): LiveData<List<ObjectModel>>

    @Query("SELECT * FROM object_data_table WHERE object_category = :nameCategory AND object_price = :priceObject")
    fun getFilter(nameCategory:String, priceObject:String): LiveData<List<ObjectModel>>

    // @Query("SELECT * FROM object_data_table WHERE object_category = 'Квартира' AND object_price = '2000000'")
    //fun getClothes(): LiveData<List<ObjectModel>>

    // @Query("SELECT * FROM object_data_table WHERE object_category = :nameCategory OR object_price = :price")
    //fun getThreeVariant(nameCategory:String, price:String): LiveData<List<ObjectModel>>
}