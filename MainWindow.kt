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

@Composable
fun LoginScreen(onLogin: (String, Boolean) -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("University Computer Reservation System", style = MaterialTheme.typography.h4)
        Spacer(Modifier.height(32.dp))
        
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.width(300.dp)
        )
        
        Spacer(Modifier.height(8.dp))
        
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.width(300.dp)
        )
        
        Spacer(Modifier.height(16.dp))
        
        Button(onClick = { onLogin(username, false) }) {
            Text("Login")
        }
        
        Spacer(Modifier.height(8.dp))
        
        TextButton(onClick = {}) {
            Text("Sign Up")
        }
    }
}

@Composable
fun AdminDashboard() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Admin Dashboard", style = MaterialTheme.typography.h5)
        // Admin features will be implemented here
    }
}

@Composable
fun StudentDashboard() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Student Dashboard", style = MaterialTheme.typography.h5)
        // Student features will be implemented here
    }
}
