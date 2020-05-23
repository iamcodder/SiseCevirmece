package com.frappeclub.sisecevirmece.interfaces

import androidx.room.*
import com.frappeclub.sisecevirmece.model.DogrulukModel

@Dao
interface DogrulukDao {

    @Insert
    fun insert(model: DogrulukModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<DogrulukModel>)

    @Update
    fun update(model: DogrulukModel)

    @Delete
    fun delete(model: DogrulukModel)

    @Query("Update DogrulukTablosu Set sorulduMu = 0")
    fun updateAll()

    @Query("Select * from DogrulukTablosu Where soruId = :id")
    fun getModel(id: Int): DogrulukModel

    @Query("Select * from DogrulukTablosu")
    fun getAllModel(): List<DogrulukModel>

}