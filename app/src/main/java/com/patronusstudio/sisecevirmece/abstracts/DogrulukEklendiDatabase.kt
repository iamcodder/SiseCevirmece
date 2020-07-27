package com.patronusstudio.sisecevirmece.abstracts

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.patronusstudio.sisecevirmece.enums.DatabaseNameEnum
import com.patronusstudio.sisecevirmece.interfaces.DogrulukEklendiDao
import com.patronusstudio.sisecevirmece.model.DogrulukSoruEklenenModel

@Database(entities = [DogrulukSoruEklenenModel::class], version = 1)
abstract class DogrulukEklendiDatabase : RoomDatabase() {

    abstract fun dogrulukEklenenDao(): DogrulukEklendiDao

    companion object {

        private var dogrulukEklenenDb: DogrulukEklendiDatabase? = null

        fun getDatabaseManager(mContext: Context): DogrulukEklendiDatabase {
            if (dogrulukEklenenDb == null) {
                dogrulukEklenenDb = Room.databaseBuilder(
                    mContext,
                    DogrulukEklendiDatabase::class.java,
                    DatabaseNameEnum.SORU_EKLEME_DOGRULUK_DB.getDatabaseName()
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return dogrulukEklenenDb!!
        }

    }

}