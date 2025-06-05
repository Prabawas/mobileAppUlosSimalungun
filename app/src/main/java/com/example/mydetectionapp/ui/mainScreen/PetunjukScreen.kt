package com.example.mydetectionapp.ui.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetunjukScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Petunjuk Penggunaan",
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Kembali", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF008577))
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFF0F8FF))
        ) {
            // Supaya kontennya bisa discroll dan gak kepotong
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                InstructionCard(
                    icon = Icons.Default.CameraAlt,
                    title = "Deteksi Ulos Lewat Kamera",
                    description = "Tekan tombol 'Buka Kamera' untuk memulai deteksi kain ulos. Setelah deteksi berhasil, akan muncul tombol hasil deteksi di bawah layar kamera. Tekan tombol tersebut untuk melihat penjelasan lengkap tentang kain ulos yang terdeteksi."
                )

                Spacer(modifier = Modifier.height(12.dp))

                InstructionCard(
                    icon = Icons.Default.Warning,
                    title = "Jarak Optimal Kamera",
                    description = "Agar hasil deteksi kain ulos Simalungun lebih maksimal, sangat disarankan untuk menjaga jarak kamera dengan objek kain ulos sekitar 15 - 30 cm."
                )

                Spacer(modifier = Modifier.height(12.dp))

                InstructionCard(
                    icon = Icons.Default.List,
                    title = "Lihat Daftar Kain Ulos",
                    description = "Tekan tombol 'Lihat Kain Ulos' untuk melihat seluruh jenis kain ulos yang ada dalam aplikasi ini. Setiap jenis memiliki informasi lengkap seperti deskripsi, kegunaan, makna, hingga cara pakai."
                )
            }
        }
    }
}

@Composable
fun InstructionCard(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = Color(0xFF008577),
                modifier = Modifier
                    .size(32.dp)
                    .padding(top = 4.dp) // Biar sejajar vertikal sama teks
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF008577)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    lineHeight = 20.sp
                )
            }
        }
    }
}





//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun PetunjukScreen(navController: NavController) {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(
//                        "Petunjuk Penggunaan",
//                        color = Color.White
//                    )
//                },
//                navigationIcon = {
//                    IconButton(onClick = { navController.popBackStack() }) {
//                        Icon(Icons.Default.ArrowBack, contentDescription = "Kembali", tint = Color.White)
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF008577))
//            )
//        }
//    ) { innerPadding ->
//        Column(
//            modifier = Modifier
//                .padding(innerPadding)
//                .padding(16.dp)
//                .fillMaxSize()
//                .background(Color(0xFFF0F8FF)),
//            verticalArrangement = Arrangement.Top
//        ) {
//            InstructionCard(
//                icon = Icons.Default.CameraAlt,
//                title = "Deteksi Ulos Lewat Kamera",
//                description = "Tekan tombol 'Buka Kamera' untuk memulai deteksi kain ulos. Setelah deteksi berhasil, akan muncul tombol hasil deteksi di bawah layar kamera. Tekan tombol tersebut untuk melihat penjelasan lengkap tentang kain ulos yang terdeteksi."
//            )
//
//            Spacer(modifier = Modifier.height(12.dp))
//
//            InstructionCard(
//                icon = Icons.Default.Warning,
//                title = "Jarak Optimal Kamera",
//                description = "Agar hasil deteksi kain ulos Simalungun lebih maksimal, sangat disarankan untuk menjaga jarak kamera dengan objek kain ulos sekitar 15 - 30 cm."
//            )
//
//            Spacer(modifier = Modifier.height(12.dp))
//
//            InstructionCard(
//                icon = Icons.Default.List,
//                title = "Lihat Daftar Kain Ulos",
//                description = "Tekan tombol 'Lihat Kain Ulos' untuk melihat seluruh jenis kain ulos yang ada dalam aplikasi ini. Setiap jenis memiliki informasi lengkap seperti deskripsi, kegunaan, makna, hingga cara pakai."
//            )
//        }
//    }
//}
//
//@Composable
//fun InstructionCard(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, description: String) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight(),
//        shape = RoundedCornerShape(12.dp),
//        colors = CardDefaults.cardColors(containerColor = Color.White),
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//    ) {
//        Row(
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth(),
//            verticalAlignment = Alignment.Top
//        ) {
//            Icon(
//                imageVector = icon,
//                contentDescription = title,
//                tint = Color(0xFF008577),
//                modifier = Modifier.size(32.dp)
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//            Column {
//                Text(
//                    text = title,
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color(0xFF008577)
//                )
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(
//                    text = description,
//                    fontSize = 14.sp,
//                    color = Color.DarkGray,
//                    lineHeight = 20.sp
//                )
//            }
//        }
//    }
//}

