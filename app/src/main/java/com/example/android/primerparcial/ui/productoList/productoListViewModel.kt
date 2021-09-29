package com.example.android.primerparcial.ui.productoList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.android.primerparcial.data.productoDb
import com.example.android.primerparcial.model.producto
import com.example.android.primerparcial.repository.productoRepository
import kotlinx.coroutines.launch


class productoListViewModel(application: Application) : ViewModel() {

    private val productoRepository = productoRepository(productoDb.getInstance(application))

    val list = productoRepository.Lista()

    //Clase Factory
    class Factory(val app: Application) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(productoListViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return productoListViewModel(app) as T
            }
            throw IllegalAccessException("Unable to construct viewmodel")
        }
    }
}