package com.patronusstudio.sisecevirmece.interfaces

import androidx.room.*
import com.patronusstudio.sisecevirmece.model.CesaretModel

@Dao
interface CesaretDao {

    @Insert
    fun insert(model: CesaretModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<CesaretModel>)

    @Delete
    fun delete(model: CesaretModel)

    @Query("DELETE FROM CesaretTablosu")
    fun deleteAllModel()

    @Update
    fun update(model: CesaretModel)

    @Query("Update CesaretTablosu Set sorulduMu = 0")
    fun updateAll()

    @Query("Select * from CesaretTablosu Where soruId = :id")
    fun getModel(id: Int): CesaretModel?

    @Query("Select * from CesaretTablosu")
    fun getAllModel(): List<CesaretModel>

}