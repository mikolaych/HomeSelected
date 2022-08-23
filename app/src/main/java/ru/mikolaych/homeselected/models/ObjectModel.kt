package ru.mikolaych.homeselected.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "object_data_table")
data class ObjectModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "object_id")
    var id:Int,

    @ColumnInfo(name = "object_category")
    var category:String,

    @ColumnInfo(name = "object_city")
    var city:String,

    @ColumnInfo(name = "object_street")
    var street:String,

    @ColumnInfo(name = "object_house")
    var house:String,

    @ColumnInfo(name = "object_flat")
    var flat:String,

    @ColumnInfo(name = "object_room_number")
    var roomNumber:String,

    @ColumnInfo(name = "object_square")
    var square:String,

    @ColumnInfo(name = "object_floor")
    var floor:String,

    @ColumnInfo(name = "object_floor_house")
    var floorHouse:String,

    @ColumnInfo(name = "object_price")
    var price:String,

    @ColumnInfo(name = "object_repair")
    var repair:String,

    @ColumnInfo(name = "object_phone")
    var phone:String,

    @ColumnInfo(name = "object_contact_name")
    var contactName:String,

    @ColumnInfo(name = "object_commentaries")
    var commentaries:String,

)
