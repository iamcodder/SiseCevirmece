package com.patronusstudio.sisecevirmece.interfaces

import androidx.room.*
import com.patronusstudio.sisecevirmece.model.CesaretSoruEklenenModel

@Dao
interface CesaretEklendiDao {

    @Insert
    fun insert(model: CesaretSoruEklenenModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<CesaretSoruEklenenModel>)

    @Delete
    fun delete(model: CesaretSoruEklenenModel)

    @Query("DELETE FROM CesaretEklenenTablosu")
    fun deleteAllModel()

    @Update
    fun update(model: CesaretSoruEklenenModel)

    @Query("Update CesaretEklenenTablosu Set sorulduMu = 0")
    fun updateAll()

    @Query("Select * from CesaretEklenenTablosu Where soruId = :id")
    fun getModel(id: Int): CesaretSoruEklenenModel?

    @Query("Select * from CesaretEklenenTablosu")
    fun getAllModel(): List<CesaretSoruEklenenModel>

}