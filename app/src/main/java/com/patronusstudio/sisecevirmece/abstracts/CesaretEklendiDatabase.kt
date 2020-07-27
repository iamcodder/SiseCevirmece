package com.patronusstudio.sisecevirmece.abstracts

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.patronusstudio.sisecevirmece.enums.DatabaseNameEnum
import com.patronusstudio.sisecevirmece.interfaces.CesaretEklendiDao
import com.patronusstudio.sisecevirmece.model.CesaretSoruEklenenModel

@Database(entities = [CesaretSoruEklenenModel::class], version = 1)
abstract class CesaretEklendiDatabase : RoomDatabase() {

    abstract fun cesareEklenentDao(): CesaretEklendiDao

    companion object {

        private var cesaretEklenenDb: CesaretEklendiDatabase? = null

        fun getDatabaseManager(mContext: Context): CesaretEklendiDatabase {
            if (cesaretEklenenDb == null) {
                cesaretEklenenDb = Room.databaseBuilder(
                    mContext,
                    CesaretEklendiDatabase::class.java,
                    DatabaseNameEnum.SORU_EKLEME_CESARET_DB.getDatabaseName()
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return cesaretEklenenDb!!
        }

    }
}