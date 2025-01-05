package com.university.booking.model

import java.time.LocalDateTime

data class TimeSlot(
    val id: String,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val computerId: String,
    val userId: String?
)
