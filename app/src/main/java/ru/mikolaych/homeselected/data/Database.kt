package ru.mikolaych.homeselected.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.mikolaych.homeselected.models.CategoryModel
import ru.mikolaych.homeselected.models.ObjectModel


@Database(entities = [CategoryModel::class, ObjectModel::class],version = 1)
abstract class Database :RoomDatabase(){

    abstract val objectDao:ObjectDao
    abstract val categoryDao:CategoryDao

    companion object{
        @Volatile
        private var INSTANCE : ru.mikolaych.homeselected.data.Database? = null
        fun getInstance(context: Context):ru.mikolaych.homeselected.data.Database{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ru.mikolaych.homeselected.data.Database::class.java,
                        "database"
                    ).build()
                }
                return instance
            }
        }

    }

}