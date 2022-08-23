package ru.mikolaych.homeselected.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.mikolaych.homeselected.repositories.ObjectRepository

class ObjectFactory (private val objectRepository: ObjectRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ObjectViewModel::class.java)) {
            return ObjectViewModel(objectRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}