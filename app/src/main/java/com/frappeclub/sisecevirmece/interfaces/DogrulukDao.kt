package com.frappeclub.sisecevirmece.interfaces

import androidx.room.*
import com.frappeclub.sisecevirmece.model.DogrulukModel

@Dao
interface DogrulukDao {

    @Insert
    fun insert(model: DogrulukModel)

    @Update
    fun update(model: DogrulukModel)

    @Delete
    fun delete(model: DogrulukModel)

    @Query("Select * from DogrulukTablosu Where soruId = :id")
    fun getModel(id: Int): DogrulukModel

    @Query("Select * from DogrulukTablosu")
    fun getAllModel(): List<DogrulukModel>

}