package model

data class AdminUser(
    override val username: String,
    override val password: String
) : User
