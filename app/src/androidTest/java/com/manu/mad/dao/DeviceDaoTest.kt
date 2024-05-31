package com.manu.mad.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.manu.mad.database.RoomDatabaseImp
import com.manu.mad.entity.Device
import com.manu.mad.enums.DeviceType
import com.manu.mad.enums.RoomType
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException

class DeviceDaoTest {

    private lateinit var roomDao: RoomDao
    private lateinit var deviceDao: DeviceDao
    private lateinit var db: RoomDatabaseImp

    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()
        db = Room.inMemoryDatabaseBuilder(context, RoomDatabaseImp::class.java)
            .allowMainThreadQueries()
            .build()
        deviceDao = db.deviceDao()
        roomDao = db.roomDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun deleteRoom(): Unit = runBlocking {
        val room =
            com.manu.mad.entity.Room("Room_name", "Test case room", 12f, RoomType.LIVING_ROOM)
        roomDao.addRoom(room)
        val device = Device("Dev_name", DeviceType.SMART_LAMP, true, 12.0, 1111, 1111, 1)
        deviceDao.addDevice(device)
        deviceDao.deleteDevice(1)
        val devices = deviceDao.getDevices().value
        devices?.isEmpty()?.let { assert(it) }
    }

}