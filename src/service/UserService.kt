package service

import model.User
import model.RegularUser
import model.AdminUser
import service.LoginSystem

class UserService {
    private val loginSystem = LoginSystem()
    private val regularUsers = mutableMapOf<String, RegularUser>()
    private val adminUsers = mutableMapOf<String, AdminUser>()

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

    fun validateUser(username: String, password: String): User? {
        return loginSystem.login(username, password)
    }

    fun isAdmin(user: User): Boolean {
        return user is AdminUser
    }
}
