package com.university.booking.model

data class Room(
    val id: String,
    val building: String,
    val computerCount: Int,
    val operatingSystem: OperatingSystem
)

enum class OperatingSystem {
    WINDOWS,
    MAC,
    LINUX
}
