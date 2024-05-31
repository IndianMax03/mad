package com.manu.mad.viewModel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.manu.mad.database.RoomDatabaseImp
import com.manu.mad.entity.Room
import com.manu.mad.enums.RoomType
import com.manu.mad.repository.RoomRepository

class RoomViewModel(application: Application) : ViewModel() {

    private val repository: RoomRepository

    val roomList: LiveData<List<Room>>
    var roomName by mutableStateOf("")
    var roomDescription by mutableStateOf("")
    var roomSize by mutableFloatStateOf(0.0f)
    var roomType: RoomType by mutableStateOf(RoomType.DEFAULT_ROOM)

    init {
        val roomDb = RoomDatabaseImp.getInstance(application)
        val roomDao = roomDb.roomDao()
        repository = RoomRepository(roomDao)
        roomList = repository.roomList
    }

    fun changeName(value: String) {
        roomName = value
    }

    fun changeDescription(value: String) {
        roomDescription = value
    }

    fun changeRoomSize(value: Float) {
        roomSize = value
    }

    fun changeRoomType(value: RoomType) {
        roomType = value
    }

    fun addRoom() {
        repository.addRoom(Room(roomName, roomDescription, roomSize, roomType))
    }

    fun deleteRoom(id: Int) {
        repository.deleteRoom(id)
    }

}