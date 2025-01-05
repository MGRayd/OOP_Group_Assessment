package com.university.booking.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
