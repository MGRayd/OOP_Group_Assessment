package com.university.booking.service

import com.university.booking.service.LoginSystem

class UserService {
    private val loginSystem = LoginSystem()
    private val regularUsers = mutableMapOf<String, com.university.booking.model.RegularUser>()
    private val adminUsers = mutableMapOf<String, com.university.booking.model.AdminUser>()

    fun addUser(username: String, password: String, isAdmin: Boolean = false): Boolean {
        if (regularUsers.containsKey(username) || adminUsers.containsKey(username)) {
            return false
        }

        if (isAdmin) {
            adminUsers[username] = com.university.booking.model.AdminUser(username, password)
        } else {
            regularUsers[username] = com.university.booking.model.RegularUser(username, password)
        }
        return true
    }

    fun validateUser(username: String, password: String): com.university.booking.model.User? {
        return loginSystem.login(username, password)
    }

    fun isAdmin(user: com.university.booking.model.User): Boolean {
        return user is com.university.booking.model.AdminUser
    }
}
