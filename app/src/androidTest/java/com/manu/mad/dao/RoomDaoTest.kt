package com.manu.mad.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.manu.mad.dao.RoomDao
import com.manu.mad.database.RoomDatabaseImp
import com.manu.mad.enums.RoomType
import com.manu.mad.repository.RoomRepository
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

class RoomDaoTest {

    private lateinit var roomDao: RoomDao
    private lateinit var db: RoomDatabaseImp

    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()
        db = Room.inMemoryDatabaseBuilder(context, RoomDatabaseImp::class.java)
            .allowMainThreadQueries()
            .build()
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
        roomDao.deleteRoom(1)
        val rooms = roomDao.getRooms().value
        rooms?.isEmpty()?.let { assert(it) }
    }

}