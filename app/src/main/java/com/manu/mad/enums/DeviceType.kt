package com.manu.mad.enums

import com.manu.mad.R

enum class DeviceType(val title: String) {

    ROBOT_CLEANER("Робот-пылесос"),
    SMART_LAMP("Умная лампочка"),
    MUSIC_STATION("Музыкальная станция"),
    AIR_CONDITIONER("Кондиционер"),
    CURTAINS("Шторы"),

}

fun getDeviceImageId(deviceType: DeviceType): Int {
    return when (deviceType) {
        DeviceType.ROBOT_CLEANER -> R.drawable.robot_dust_sucker
        DeviceType.SMART_LAMP -> R.drawable.smart_lamp
        DeviceType.MUSIC_STATION -> R.drawable.music_station
        DeviceType.AIR_CONDITIONER -> R.drawable.air_conditioner
        DeviceType.CURTAINS -> R.drawable.curtains
    }
}
