package com.patronusstudio.sisecevirmece.abstracts

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.patronusstudio.sisecevirmece.enums.DatabaseNameEnum
import com.patronusstudio.sisecevirmece.interfaces.CesaretDao
import com.patronusstudio.sisecevirmece.model.CesaretModel

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
                    DatabaseNameEnum.CESARET_DB.getDatabaseName()
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return cesaretDb!!
        }

    }
}