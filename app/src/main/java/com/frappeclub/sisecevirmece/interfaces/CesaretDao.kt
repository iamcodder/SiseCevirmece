package com.frappeclub.sisecevirmece.interfaces

import androidx.room.*
import com.frappeclub.sisecevirmece.model.CesaretModel

@Dao
interface CesaretDao {

    @Insert
    fun insert(model: CesaretModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<CesaretModel>)

    @Delete
    fun delete(model: CesaretModel)

    @Update
    fun update(model: CesaretModel)

    @Query("Update CesaretTablosu Set sorulduMu = 0")
    fun updateAll()

    @Query("Select * from CesaretTablosu Where soruId = :id")
    fun getModel(id: Int): CesaretModel

    @Query("Select * from CesaretTablosu")
    fun getAllModel(): List<CesaretModel>

}