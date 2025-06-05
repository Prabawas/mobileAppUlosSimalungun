package com.example.mydetectionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mydetectionapp.ui.splash.SplashScreen
import com.example.mydetectionapp.ui.theme.MyDetectionAppTheme
import com.example.mydetectionapp.ui.home.HomeScreen
import com.example.mydetectionapp.ui.mainScreen.CameraScreen
import com.example.mydetectionapp.ui.mainScreen.PetunjukScreen
import com.example.mydetectionapp.ui.mainScreen.UlosListScreen
import com.example.mydetectionapp.ui.mainScreen.ulosDetail.UlosDetailScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyDetectionAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation() // Ini composable utama untuk navigasi
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("home") {
            HomeScreen(navController)
        }
        composable("camera") {
            CameraScreen(navController)
        }
        composable("petunjuk") {
            PetunjukScreen(navController) // <-- Buat composable ini nanti
        }
        composable("ulos") {
            UlosListScreen(navController)
        }
        composable("ulosDetail/{index}") { backStackEntry ->
            val index = backStackEntry.arguments?.getString("index")?.toIntOrNull() ?: 0
            UlosDetailScreen(index, navController)
        }

        // ⬇️ Tambahkan ini untuk navigasi ke UlosDetailScreen
        composable("ulos_detail/{ulosIndex}") { backStackEntry ->
            val index = backStackEntry.arguments?.getString("ulosIndex")?.toIntOrNull() ?: 0
            UlosDetailScreen(index = index, navController = navController)
        }
    }
}
