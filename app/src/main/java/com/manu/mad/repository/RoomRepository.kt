package com.manu.mad.repository

import androidx.lifecycle.LiveData
import com.manu.mad.dao.RoomDao
import com.manu.mad.entity.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomRepository(private val roomDao: RoomDao) {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val roomList: LiveData<List<Room>> = roomDao.getRooms()

    fun addRoom(room: Room) {
        coroutineScope.launch(Dispatchers.IO) {
            roomDao.addRoom(room)
        }
    }

    fun deleteRoom(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            roomDao.deleteRoom(id)
        }
    }

}