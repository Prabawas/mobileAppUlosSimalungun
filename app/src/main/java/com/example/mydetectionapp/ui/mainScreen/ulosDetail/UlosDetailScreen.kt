package com.example.mydetectionapp.ui.mainScreen.ulosDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UlosDetailScreen(index: Int, navController: NavController) {
    val selectedUlos = ulosListData.getOrNull(index)

    if (selectedUlos == null) {
        // Kalau index nggak valid
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Ulos Tidak Ditemukan") },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Data ulos tidak tersedia.", color = Color.Red)
            }
        }
        return
    }

    val usuGreen = Color(0xFF008577)
    val backgroundColor = Color(0xFFE5F5FF)

    Scaffold(
        containerColor = backgroundColor,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        selectedUlos.name,
                        color = Color.White,
                        style = MaterialTheme.typography.headlineSmall
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
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
                colors = TopAppBarDefaults.topAppBarColors(containerColor = usuGreen)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Gambar-gambar Ulos
            UlosImage(selectedUlos.imageRes1)
            UlosImage(selectedUlos.imageRes2)

            // Informasi Detail
            DetailSection("Deskripsi", selectedUlos.description, usuGreen)
            DetailSection("Kegunaan", selectedUlos.usage, usuGreen)
            // Tambahkan ini di sini
            HowToWearImagesRow(
                imageRes1 = selectedUlos.howToWearImageRes1,
                imageRes2 = selectedUlos.howToWearImageRes2
            )
            DetailSection("Cara Pakai", selectedUlos.howToWear, usuGreen)
            DetailSection("Makna", selectedUlos.meaning, usuGreen)
            DetailSection("Penjelasan Tambahan", selectedUlos.extraInfo, usuGreen)
        }
    }
}

@Composable
fun UlosImage(imageRes: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Gambar Ulos",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun DetailSection(title: String, content: String, titleColor: Color) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = titleColor
                )
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.DarkGray)
            )
        }
    }
}

@Composable
fun HowToWearImagesRow(imageRes1: Int, imageRes2: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ImageCard(imageRes = imageRes1, modifier = Modifier.weight(1f))
        ImageCard(imageRes = imageRes2, modifier = Modifier.weight(1f))
    }
}

@Composable
fun ImageCard(imageRes: Int, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Gambar Cara Pakai Ulos",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}
