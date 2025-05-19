package com.example.mydetectionapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.example.mydetectionapp.R

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE5F5FF))
            .padding(horizontal = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(34.dp))

            Text(
                text = "Selamat Datang di Aplikasi Deteksi Kain Ulos Simalungun Secara Realtime",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFF008577),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Gray,
                        offset = Offset(2f, 2f),
                        blurRadius = 4f
                    )
                ),
                modifier = Modifier
                    .padding(horizontal = 12.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Image(
                painter = painterResource(id = R.drawable.logo_usu),
                contentDescription = "Logo Universitas Sumatera Utara",
                modifier = Modifier
                    .size(110.dp)
                    .shadow(6.dp, shape = CircleShape) // shadow halus logo
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navController.navigate("camera") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .shadow(4.dp, RoundedCornerShape(12.dp)),
                colors = ButtonDefaults.buttonColors(Color(0xFF008577)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Buka Kamera", color = Color.White, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("ulos") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .shadow(4.dp, RoundedCornerShape(12.dp)),
                colors = ButtonDefaults.buttonColors(Color(0xFF008577)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Lihat Kain Ulos", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}