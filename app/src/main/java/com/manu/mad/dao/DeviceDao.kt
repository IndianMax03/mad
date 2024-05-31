package com.manu.mad.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.manu.mad.entity.Device

@Dao
interface DeviceDao {

    @Query("SELECT * FROM devices")
    fun getDevices(): LiveData<List<Device>>

    @Query("SELECT * FROM DEVICES WHERE id = :id")
    fun getDevice(id: Int): Device

    @Insert
    fun addDevice(device: Device)

    @Update
    fun updateDevice(device: Device)

    @Query("DELETE FROM devices WHERE id = :id")
    fun deleteDevice(id: Int)

}