package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import service.UserService

fun main() = application {
    val userService = remember { UserService() }
    
    Window(
        onCloseRequest = ::exitApplication,
        title = "University Computer Reservation System",
        state = rememberWindowState(width = 1024.dp, height = 768.dp)
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

@Composable
fun AdminDashboard() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Admin Dashboard", style = MaterialTheme.typography.h4)
        // Admin features will be implemented here
    }
}

@Composable
fun StudentDashboard() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Student Dashboard", style = MaterialTheme.typography.h4)
        // Student features will be implemented here
    }
}
