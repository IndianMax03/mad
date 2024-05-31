package com.manu.mad.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.manu.mad.enums.RoomType


@Entity(tableName = "rooms")
class Room {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "description")
    var description: String = ""

    @ColumnInfo(name = "size_sq_m")
    var sizeSqM: Float = 0f

    @ColumnInfo(name = "room_type")
    var roomType: RoomType = RoomType.DEFAULT_ROOM;

    constructor() {}

    constructor(name: String, description: String, sizeSqM: Float, roomType: RoomType) {
        this.name = name
        this.description = description
        this.sizeSqM = sizeSqM
        this.roomType = roomType
    }
}
