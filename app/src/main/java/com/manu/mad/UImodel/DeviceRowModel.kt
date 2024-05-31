package com.manu.mad.UImodel

data class DeviceRowModel(
    val deviceId: Int,
    val imageId: Int,
    val title: String,
    val isActive: Boolean,
    val voltage: Double,
    val uptime: Long,
    val roomName: String,
) {
}