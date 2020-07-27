package com.patronusstudio.sisecevirmece.abstracts

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.patronusstudio.sisecevirmece.enums.DatabaseNameEnum
import com.patronusstudio.sisecevirmece.interfaces.DogrulukDao
import com.patronusstudio.sisecevirmece.model.DogrulukModel

@Database(entities = [DogrulukModel::class], version = 1)
abstract class DogrulukDatabase : RoomDatabase() {

    abstract fun dogrulukDao(): DogrulukDao

    companion object {

        private var dogrulukDb: DogrulukDatabase? = null

        fun getDatabaseManager(mContext: Context): DogrulukDatabase {
            if (dogrulukDb == null) {
                dogrulukDb = Room.databaseBuilder(
                    mContext,
                    DogrulukDatabase::class.java,
                    DatabaseNameEnum.DOGRULUK_DB.getDatabaseName()
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return dogrulukDb!!
        }

    }

}