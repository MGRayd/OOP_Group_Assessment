package service

import model.User
import model.RegularUser
import model.AdminUser

class LoginSystem {
    private val regularUsers = mutableMapOf<String, RegularUser>()
    private val adminUsers = mutableMapOf<String, AdminUser>()

    init {
        adminUsers["admin"] = AdminUser("admin", "letmein")
        regularUsers["student1"] = RegularUser("student1", "labadmin")
        regularUsers["student2"] = RegularUser("student2", "racecar")
    }

    fun login(username: String, password: String): User? {
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

    fun addUser(username: String, password: String, isAdmin: Boolean = false): Boolean {
        if (regularUsers.containsKey(username) || adminUsers.containsKey(username)) {
            return false
        }

        if (isAdmin) {
            adminUsers[username] = AdminUser(username, password)
        } else {
            regularUsers[username] = RegularUser(username, password)
        }
        return true
    }

    fun isAdmin(user: User): Boolean {
        return user is AdminUser
    }
}
