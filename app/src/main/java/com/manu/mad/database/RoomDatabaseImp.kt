package com.manu.mad.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.manu.mad.entity.Room as MyRoom
import androidx.room.RoomDatabase
import com.manu.mad.dao.DeviceDao
import com.manu.mad.dao.RoomDao
import com.manu.mad.entity.Device

@Database(
    entities = [MyRoom::class, Device::class],
    version = 1
)
abstract class RoomDatabaseImp : RoomDatabase() {

    abstract fun roomDao(): RoomDao

    abstract fun deviceDao(): DeviceDao

    companion object {

        private var INSTANCE: com.manu.mad.database.RoomDatabaseImp? = null

        fun getInstance(context: Context): com.manu.mad.database.RoomDatabaseImp {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.inMemoryDatabaseBuilder(
                        context.applicationContext,
                        RoomDatabaseImp::class.java,
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }

}