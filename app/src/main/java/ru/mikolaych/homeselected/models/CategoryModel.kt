package ru.mikolaych.homeselected.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_data_table")
data class CategoryModel (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "categories_id")
    var id:Int,

    @ColumnInfo(name = "category_name")
    var name:String
)