package com.frappeclub.sisecevirmece.abstracts

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.frappeclub.sisecevirmece.interfaces.CesaretDao
import com.frappeclub.sisecevirmece.model.CesaretModel

@Database(entities = [CesaretModel::class], version = 1)
abstract class CesaretDatabase : RoomDatabase() {

    abstract fun cesaretDao(): CesaretDao

    companion object {

        private var cesaretDb: CesaretDatabase? = null

        fun getDatabaseManager(mContext: Context): CesaretDatabase {
            if (cesaretDb == null) {
                cesaretDb = Room.databaseBuilder(
                    mContext,
                    CesaretDatabase::class.java,
                    "Cesaret.db"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return cesaretDb!!
        }

    }
}