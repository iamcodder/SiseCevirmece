package com.frappeclub.sisecevirmece.abstracts

import androidx.room.Database
import androidx.room.RoomDatabase
import com.frappeclub.sisecevirmece.interfaces.DogrulukDao
import com.frappeclub.sisecevirmece.model.DogrulukModel

@Database(entities = [DogrulukModel::class], version = 1)
abstract class SorularDatabase : RoomDatabase() {

    abstract fun dogrulukDao(): DogrulukDao

}