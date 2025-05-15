package com.example.mydetectionapp.ui.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

val ulosList = listOf(
    "Ulos Bittang Maratur",
    "Ulos Bulang",
    "Ulos Hati Rongga",
    "Ulos Mangiring",
    "Ulos Ragi Idup",
    "Ulos Ragi Santik",
    "Ulos Simangkat Angkat",
    "Ulos Sitoluntuho",
    "Ulos Suri Suri",
    "Ulos Tapak Satur"
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UlosListScreen(navController: NavController) {
    val usuGreen = Color(0xFF008577)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Daftar Kain Ulos",
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .background(Color.White, shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = usuGreen
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = usuGreen
                )
            )
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE5F5FF)) // Latar belakang soft biru (kayak halaman sebelumnya)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            itemsIndexed(ulosList) { index, ulosName ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable {
                            navController.navigate("ulosDetail/$index")
                        },
                    elevation = CardDefaults.cardElevation(6.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${index + 1}. $ulosName",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF004D40) // Variasi hijau tua biar enak dilihat
                            )
                        )
                    }
                }
            }
        }
    }
}