package ru.mikolaych.homeselected.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.mikolaych.homeselected.models.ObjectModel
import ru.mikolaych.homeselected.repositories.ObjectRepository

class ObjectViewModel (private val objectRepository: ObjectRepository) : ViewModel() {

    val products = objectRepository.objects


    fun getFilter (nameCategory:String, priceObject: String):
            LiveData<List<ObjectModel>> {
        return objectRepository.getFilter(nameCategory, priceObject)
    }

    fun startInsert(categoryObject:String, cityObject:String, streetObject:String, houseObject:String, flatObject:String, roomNumberObject:String, squareObject:String, floorObject:String, floorHouseObject:String, priceObject: String, repairObject:String, phoneObject:String, contactNameObject:String, commentariesObject:String ) {
        insertObject(ObjectModel(0, categoryObject, cityObject, streetObject, houseObject, flatObject, roomNumberObject, squareObject, floorObject, floorHouseObject, priceObject, repairObject, phoneObject, contactNameObject, commentariesObject ))
    }

    fun startUpdateObject(idObject:Int, categoryObject:String, cityObject:String, streetObject:String, houseObject:String, flatObject:String, roomNumberObject:String, squareObject:String, floorObject:String, floorHouseObject:String, priceObject: String, repairObject:String, phoneObject:String, contactNameObject:String, commentariesObject:String ) {
        updateObject(ObjectModel(idObject, categoryObject, cityObject, streetObject, houseObject, flatObject, roomNumberObject, squareObject, floorObject, floorHouseObject, priceObject, repairObject, phoneObject, contactNameObject, commentariesObject ))
    }

    private fun insertObject(objectModel: ObjectModel) = viewModelScope.launch{

        objectRepository.insertObject(objectModel)
    }

    private fun updateObject(objectModel: ObjectModel) = viewModelScope.launch{

        objectRepository.updateObject(objectModel)
    }

    fun deleteObject(objectModel: ObjectModel) = viewModelScope.launch{

        objectRepository.deleteObject(objectModel)
    }

    fun deleteAllObjects() = viewModelScope.launch{

        objectRepository.deleteAllObjects()
    }


}