package com.university.booking.model

data class RegularUser(
    override val username: String,
    override val password: String
) : User
