package com.example.mydetectionapp.ui.splash

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mydetectionapp.R
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    // Navigasi ke home setelah delay
    LaunchedEffect(true) {
        delay(5000)
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true }
        }
    }

    // Animasi warna loading indicator
    val infiniteTransition = rememberInfiniteTransition()
    val animatedColor by infiniteTransition.animateColor(
        initialValue = Color(0xFF008577),
        targetValue = Color(0xFFFFC107),
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Hiasan atas
        Image(
            painter = painterResource(id = R.drawable.ulos_bittang_maratur_1),
            contentDescription = "Hiasan Atas",
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .align(Alignment.TopCenter),
            contentScale = ContentScale.FillWidth
        )

        // Hiasan bawah
        Image(
            painter = painterResource(id = R.drawable.ulos_bittang_maratur_2),
            contentDescription = "Hiasan Bawah",
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.FillWidth
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Judul
            Text(
                text = "Deteksi Kain Ulos Simalungun\nMenggunakan SSD MobileNetV3",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color(0xFF007E33) // Hijau USU
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Logo statik (tidak berdenyut)
            Image(
                painter = painterResource(id = R.drawable.logo_usu),
                contentDescription = "Logo USU",
                modifier = Modifier.size(140.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Info developer
            Text(text = "Afdoni Prabawa Said", fontSize = 16.sp, color = Color.Black)
            Text(text = "201402118", fontSize = 16.sp, color = Color.Black)
            Text(text = "Teknologi Informasi - USU 2020", fontSize = 16.sp, color = Color.Black)

            Spacer(modifier = Modifier.height(36.dp))

            // Loading berwarna dinamis
            CircularProgressIndicator(
                modifier = Modifier.size(50.dp),
                color = animatedColor,
                strokeWidth = 5.dp
            )
        }
    }
}







//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import com.example.mydetectionapp.R
//import kotlinx.coroutines.delay
//
//@Composable
//fun SplashScreen(navController: NavController) {
//    // Menambahkan delay untuk splash screen selama 5 detik
//    LaunchedEffect(true) {
//        delay(5000) // tampil selama 5 detik
//        navController.navigate("home") {
//            popUpTo("splash") { inclusive = true }
//        }
//    }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(24.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            // Teks judul aplikasi
//            Text(
//                text = "Deteksi Kain Ulos Simalungun\nMenggunakan SSD MobileNetV3",
//                fontWeight = FontWeight.Bold,
//                fontSize = 20.sp,
//                textAlign = TextAlign.Center,
//                color = Color.Black
//            )
//            Spacer(modifier = Modifier.height(24.dp))
//
//            // Logo aplikasi
//            Image(
//                painter = painterResource(id = R.drawable.logo_usu), // pastikan file logo_usu.png ada di drawable
//                contentDescription = "Logo USU",
//                modifier = Modifier.size(120.dp)
//            )
//            Spacer(modifier = Modifier.height(24.dp))
//
//            // Info tentang pengembang
//            Text(
//                text = "Afdoni Prabawa Said",
//                fontSize = 16.sp,
//                color = Color.Black
//            )
//            Text(
//                text = "201402118",
//                fontSize = 16.sp,
//                color = Color.Black
//            )
//            Text(
//                text = "Teknologi Informasi USU 2020 Medan",
//                fontSize = 16.sp,
//                color = Color.Black
//            )
//
//            // Spacer untuk memberi jarak sebelum CircularProgressIndicator
//            Spacer(modifier = Modifier.height(36.dp))
//
//            // Circular Progress Indicator
//            CircularProgressIndicator(
//                modifier = Modifier.size(50.dp),
//                color = Color(0xFF008577) // bisa diganti dengan warna lain
//            )
//        }
//    }
//}


