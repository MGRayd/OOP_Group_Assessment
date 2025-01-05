package com.university.booking.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AdminDashboard() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Admin Dashboard", style = MaterialTheme.typography.h5)
        // Admin features will be implemented here
    }
}
