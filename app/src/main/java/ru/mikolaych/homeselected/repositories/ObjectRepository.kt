package ru.mikolaych.homeselected.repositories

import androidx.lifecycle.LiveData
import ru.mikolaych.homeselected.data.ObjectDao
import ru.mikolaych.homeselected.models.ObjectModel

class ObjectRepository (private val objectDao: ObjectDao) {

    val objects = objectDao.getAllObjects()

    fun getFilter (nameCategory:String, priceObject:String):
            LiveData<List<ObjectModel>> {
        return objectDao.getFilter(nameCategory, priceObject)
    }


    suspend fun insertObject(objectModel: ObjectModel){
        objectDao.insertObject(objectModel)
    }

    suspend fun updateObject(objectModel: ObjectModel){
        objectDao.updateObject(objectModel)
    }

    suspend fun deleteObject(objectModel: ObjectModel) {
        objectDao.deleteObject(objectModel)
    }

    suspend fun deleteAllObjects(){
        objectDao.deleteAllObjects()
    }
}
