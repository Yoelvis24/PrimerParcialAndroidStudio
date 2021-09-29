package com.example.android.primerparcial.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.primerparcial.model.producto

@Dao
interface productoDao {
    @Insert
    suspend fun Insert(producto: producto)

    @Update
    suspend fun Update(producto: producto)

    @Delete
    suspend fun Delete(producto: producto)

    @Query("SELECT * FROM producto WHERE ProductoId = :key")
    suspend fun Find(key:Long):producto

    @Query("SELECT * FROM producto order by ProductoId asc")
    fun Lista() : LiveData<List<producto>>
}