package com.example.android.primerparcial.model

import androidx.room.*

@Entity
data class producto(
    @PrimaryKey(autoGenerate = true)
    var ProductoId: Long,
    var Descripcion: String,
    var Existencia: Float,
    var Costo: Float,
    var ValorInventario: Float
)