package com.aransafp.rickandmor.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aransafp.rickandmor.data.api.ApiHelper
import com.aransafp.rickandmor.data.repository.MainRepository
import com.aransafp.rickandmor.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unkown class name")
    }
}