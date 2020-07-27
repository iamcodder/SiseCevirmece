package com.patronusstudio.sisecevirmece.interfaces

import androidx.room.*
import com.patronusstudio.sisecevirmece.model.DogrulukSoruEklenenModel

@Dao
interface DogrulukEklendiDao {

    @Insert
    fun insert(model: DogrulukSoruEklenenModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<DogrulukSoruEklenenModel>)

    @Update
    fun update(model: DogrulukSoruEklenenModel)

    @Delete
    fun delete(model: DogrulukSoruEklenenModel)

    @Query("DELETE FROM DogrulukEklenenTablosu")
    fun deleteAllModel()

    @Query("Update DogrulukEklenenTablosu Set sorulduMu = 0")
    fun updateAll()

    @Query("Select * from DogrulukEklenenTablosu Where soruId = :id")
    fun getModel(id: Int): DogrulukSoruEklenenModel?

    @Query("Select * from DogrulukEklenenTablosu")
    fun getAllModel(): List<DogrulukSoruEklenenModel>

}