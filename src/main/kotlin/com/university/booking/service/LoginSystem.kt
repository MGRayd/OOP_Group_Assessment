package com.university.booking.service

class LoginSystem {
    private val regularUsers = mutableMapOf<String, com.university.booking.model.RegularUser>()
    private val adminUsers = mutableMapOf<String, com.university.booking.model.AdminUser>()

    init {
        adminUsers["admin"] = com.university.booking.model.AdminUser("admin", "letmein")
        regularUsers["student1"] = com.university.booking.model.RegularUser("student1", "labadmin")
        regularUsers["student2"] = com.university.booking.model.RegularUser("student2", "racecar")
    }

    fun login(username: String, password: String): com.university.booking.model.User? {
        val regularUser = regularUsers[username]
        val adminUser = adminUsers[username]

        if (regularUser?.password == password) {
            return regularUser
        }

        if (adminUser?.password == password) {
            return adminUser
        }

        return null
    }
}
