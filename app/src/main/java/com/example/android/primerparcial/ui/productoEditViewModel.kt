package com.example.android.primerparcial.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.room.Update
import com.example.android.primerparcial.data.productoDb
import com.example.android.primerparcial.model.producto
import com.example.android.primerparcial.repository.productoRepository
import kotlinx.coroutines.launch


class productoEditViewModel (application: Application): ViewModel() {

    private  val productoRepository = productoRepository(productoDb.getInstance(application))

    fun Insert(producto: producto) = viewModelScope.launch {
        productoRepository.Insert(producto)
    }

    fun Delete(producto: producto) = viewModelScope.launch {
        productoRepository.Delete(producto)
    }

    fun Find(producto: producto) = viewModelScope.launch {
        productoRepository.Find(producto.ProductoId)
    }

    fun Update(producto: producto) = viewModelScope.launch {
        productoRepository.Update(producto)
    }

    class Factory(val app: Application) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(productoEditViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return productoEditViewModel(app) as T
            }
            throw IllegalAccessException("Unable to construct viewmodel")
        }
    }
}
