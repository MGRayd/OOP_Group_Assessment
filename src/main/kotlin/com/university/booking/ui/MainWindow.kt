package com.university.booking.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.university.booking.service.UserService

fun main() = application {
    val userService = remember { UserService() }
    
    Window(
        onCloseRequest = ::exitApplication,
        title = "University Computer Reservation System",
        state = rememberWindowState()
    ) {
        var isLoggedIn by remember { mutableStateOf(false) }
        var isAdmin by remember { mutableStateOf(false) }
        var showSignup by remember { mutableStateOf(false) }
        
        MaterialTheme {
            when {
                showSignup -> {
                    SignupScreen(
                        userService = userService,
                        onSignupSuccess = {
                            showSignup = false
                        },
                        onBackToLogin = {
                            showSignup = false
                        }
                    )
                }
                !isLoggedIn -> {
                    LoginScreen(
                        userService = userService,
                        onLogin = { username, isAdminUser ->
                            isLoggedIn = true
                            isAdmin = isAdminUser
                        },
                        onSignupClick = {
                            showSignup = true
                        }
                    )
                }
                isAdmin -> {
                    AdminDashboard()
                }
                else -> {
                    StudentDashboard()
                }
            }
        }
    }
}
