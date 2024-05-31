package com.manu.mad.viewModel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.manu.mad.database.RoomDatabaseImp
import com.manu.mad.entity.Device
import com.manu.mad.enums.DeviceType
import com.manu.mad.repository.DeviceRepository

class DeviceViewModel(application: Application) : ViewModel() {

    private val repository: DeviceRepository

    val deviceList: LiveData<List<Device>>
    var deviceName by mutableStateOf("")
    var deviceType by mutableStateOf(DeviceType.SMART_LAMP)
    var deviceIsActive by mutableStateOf(false)
    var deviceVoltage: Double by mutableDoubleStateOf(0.0)
    var prevStartMs: Long by mutableLongStateOf(0)
    var uptimeMs: Long by mutableLongStateOf(0)
    var roomId: Int by mutableIntStateOf(1)


    init {
        val roomDb = RoomDatabaseImp.getInstance(application)
        val deviceDao = roomDb.deviceDao()
        repository = DeviceRepository(deviceDao)
        deviceList = repository.deviceList
    }

    fun changeName(value: String) {
        deviceName = value
    }

    fun changeType(value: DeviceType) {
        deviceType = value
    }

    fun changeIsActive(device: Device) {
        repository.changeIsActive(device)
    }

    fun changeVoltage(value: Double) {
        deviceVoltage = value
    }

    fun changePrevStartMs(value: Long) {
        prevStartMs = value
    }

    fun changeUptimeMs(value: Long) {
        uptimeMs = value
    }

    fun changeRoomId(value: Int) {
        roomId = value
    }

    fun addDevice() {
        repository.addDevice(
            Device(
                deviceName,
                deviceType,
                deviceIsActive,
                deviceVoltage,
                prevStartMs,
                uptimeMs,
                roomId,
            )
        )
    }

    fun deleteDevice(id: Int) {
        repository.deleteDevice(id)
    }

}