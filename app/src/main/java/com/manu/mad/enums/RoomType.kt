package com.manu.mad.enums

import com.manu.mad.R

enum class RoomType(val title: String) {

    LIVING_ROOM("Гостиная"),
    BEDROOM("Спальня"),
    KITCHEN("Кухня"),
    BATHROOM("Ванная"),
    DEFAULT_ROOM("Жилая");

}

fun getRoomImageId(roomType: RoomType): Int {
    return when (roomType) {
        RoomType.LIVING_ROOM -> R.drawable.living_room
        RoomType.BEDROOM -> R.drawable.sleeping_room
        RoomType.KITCHEN -> R.drawable.kitchen_room
        RoomType.BATHROOM -> R.drawable.bath_room
        RoomType.DEFAULT_ROOM -> R.drawable.default_room
    }
}
