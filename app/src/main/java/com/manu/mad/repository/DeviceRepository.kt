package com.manu.mad.repository

import androidx.lifecycle.LiveData
import com.manu.mad.dao.DeviceDao
import com.manu.mad.entity.Device
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeviceRepository(private val deviceDao: DeviceDao) {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val deviceList: LiveData<List<Device>> = deviceDao.getDevices()

    fun addDevice(device: Device) {
        coroutineScope.launch(Dispatchers.IO) {
            deviceDao.addDevice(device)
        }
    }

    fun deleteDevice(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            deviceDao.deleteDevice(id)
        }
    }

    fun changeIsActive(device: Device) {
        coroutineScope.launch(Dispatchers.IO) {
            if (!device.isActive) {
                device.prevStartMs = System.currentTimeMillis()
                device.isActive = true
            } else {
                val uptimeDelta = System.currentTimeMillis() - device.prevStartMs
                device.uptimeMs += uptimeDelta
                device.prevStartMs = 0
                device.isActive = false
            }
            deviceDao.updateDevice(device)
        }

    }

}