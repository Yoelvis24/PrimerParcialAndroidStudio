package com.example.android.primerparcial.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.primerparcial.model.producto

@Database(
    entities = [producto::class],
    version = 1,
    exportSchema = false
)
abstract class productoDb : RoomDatabase() {

    abstract val productDao: productoDao

    companion object{

        @Volatile
        private var INSTANCE: productoDb? = null

        fun getInstance(context: Context): productoDb{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        productoDb::class.java,
                        "productoDb"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}