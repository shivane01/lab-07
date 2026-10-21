
package com.example.lab_7

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController) {

    var driverName by remember { mutableStateOf("") }
    val drivers = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.testTag("driverBackButton")
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "FormulaZero Drivers",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = driverName,
                onValueChange = { driverName = it },
                label = { Text("Driver Name") },
                modifier = Modifier
                    .weight(1f)
                    .testTag("driverInput")
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    if (driverName.isNotBlank()) {
                        drivers.add(driverName)
                        driverName = ""
                    }
                },
                modifier = Modifier.testTag("addDriverButton")
            ) {
                Text("Add")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { drivers.clear() },
            modifier = Modifier.testTag("clearDriversButton")
        ) {
            Text("Clear All Drivers")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(drivers) { driver ->
                Text(
                    text = driver,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}
