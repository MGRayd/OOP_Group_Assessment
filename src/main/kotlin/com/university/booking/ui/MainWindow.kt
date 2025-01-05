package com.university.booking.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "University Computer Reservation System",
        state = rememberWindowState(width = 1024.dp, height = 768.dp)
    ) {
        var isLoggedIn by remember { mutableStateOf(false) }
        var isAdmin by remember { mutableStateOf(false) }
        
        MaterialTheme {
            if (!isLoggedIn) {
                LoginScreen(
                    onLogin = { username, isAdminUser ->
                        isLoggedIn = true
                        isAdmin = isAdminUser
                    }
                )
            } else {
                if (isAdmin) {
                    AdminDashboard()
                } else {
                    StudentDashboard()
                }
            }
        }
    }
}
