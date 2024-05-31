package com.manu.mad.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.manu.mad.enums.DeviceType

@Entity(
    tableName = "devices",
    foreignKeys = [
        ForeignKey(
            entity = Room::class,
            parentColumns = ["id"],
            childColumns = ["room_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        ),
    ]
)
class Device {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "device_type")
    var deviceType: DeviceType = DeviceType.SMART_LAMP

    @ColumnInfo(name = "is_active")
    var isActive: Boolean = false

    @ColumnInfo(name = "voltage")
    var voltage: Double = 0.0

    @ColumnInfo(name = "prev_start_ms")
    var prevStartMs: Long = 0

    @ColumnInfo(name = "uptime_ms")
    var uptimeMs: Long = 0

    @ColumnInfo(name = "room_id")
    var roomId: Int = 0


    constructor() {}

    constructor(
        name: String,
        deviceType: DeviceType,
        isActive: Boolean,
        voltage: Double,
        prevStartMs: Long,
        uptimeMs: Long,
        roomId: Int
    ) {
        this.name = name
        this.deviceType = deviceType
        this.isActive = isActive
        this.voltage = voltage
        this.prevStartMs = prevStartMs
        this.uptimeMs = uptimeMs
        this.roomId = roomId
    }


}