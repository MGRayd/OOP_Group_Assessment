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
}
