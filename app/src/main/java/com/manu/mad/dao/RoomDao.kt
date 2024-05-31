package com.manu.mad.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.manu.mad.entity.Room

@Dao
interface RoomDao {

    @Query("SELECT * FROM rooms")
    fun getRooms(): LiveData<List<Room>>

    @Insert
    fun addRoom(room: Room)

    @Query("DELETE FROM rooms WHERE id = :id")
    fun deleteRoom(id: Int)

}