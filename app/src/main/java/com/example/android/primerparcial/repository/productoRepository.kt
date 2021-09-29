package com.example.android.primerparcial.repository

import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Update
import com.example.android.primerparcial.data.productoDb
import com.example.android.primerparcial.model.producto

class productoRepository(private val database: productoDb) {
    suspend fun Insert(producto:producto)
    {
        database.productDao.Insert(producto)
    }

    suspend fun Delete(producto: producto)
    {
        database.productDao.Delete(producto)
    }

    suspend fun Find(productoId: Long)
    {
        database.productDao.Find(productoId)
    }

    suspend fun Update(producto: producto)
    {
        database.productDao.Update(producto)
    }

    fun Lista(): LiveData<List<producto>>
    {
        return database.productDao.Lista()
    }

}