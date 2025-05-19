package com.example.mydetectionapp.ui.mainScreen

import android.Manifest
import android.graphics.*
import androidx.compose.ui.*
import androidx.camera.core.*
import android.view.ViewGroup
import androidx.compose.runtime.*
import android.widget.FrameLayout
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.camera.view.PreviewView
import androidx.navigation.NavController
import androidx.compose.ui.geometry.Size
import androidx.palette.graphics.Palette
import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.geometry.Offset
import androidx.core.content.ContextCompat
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.background
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.ui.platform.LocalLifecycleOwner

import com.google.accompanist.permissions.*

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraScreen(navController: NavController) {
    val context = LocalContext.current
    val permissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)

    val usuGreen = Color(0xFF008577)
    val usuDarkGreen = Color(0xFF004D40)
    val lightBackground = Color(0xFFE5F5FF)

    LaunchedEffect(Unit) {
        if (!permissionState.status.isGranted) {
            permissionState.launchPermissionRequest()
        }
    }

    // ✅ Daftar class ulos sesuai urutan di UlosData.kt
    val ulosList = listOf(
        "Ulos Bittang Maratur",
        "Ulos Bulang",
        "Ulos Hati Rongga",
        "Ulos Mangiring",
        "Ulos Ragi Idup",
        "Ulos Ragi Santik",
        "Ulos Simangkat-Angkat",
        "Ulos Sitoluntuho",
        "Ulos Suri-Suri",
        "Ulos Tapak Satur"
    )

    // ✅ State untuk navigasi hanya sekali
    val detectedClass = remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightBackground)
    ) {
        if (permissionState.status.isGranted) {
            // Tampilan Kamera
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(2f / 3f)
                    .padding(top = 120.dp) // ⬅️ ini yang bikin turun
                    .align(Alignment.TopCenter)
            ) {
                CameraPreviewView(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    navController = navController,
                    ulosList = ulosList,
                    detectedClass = detectedClass
                )
            }
            // ✅ Tombol Deteksi Ulos (jika confidence >= 85%)
            detectedClass.value?.let { className ->
                val index = ulosList.indexOf(className)
                if (index != -1) {
                    Button(
                        onClick = {
                            navController.navigate("ulos_detail/$index")
                        },
                        modifier = Modifier
                            .align(Alignment.BottomCenter) // Posisi tetap di bawah, tapi...
                            .padding(start = 16.dp, end = 16.dp, bottom = 90.dp), // 🔼 Ganti dari 16.dp jadi 48.dp atau sesuai kebutuhan
                        colors = ButtonDefaults.buttonColors(containerColor = usuGreen)
                    ) {
                        Text(
                            text = "Lihat detail: $className",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        } else {
            // Tampilan jika tidak ada izin kamera
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = "Camera Icon",
                    tint = usuGreen,
                    modifier = Modifier.size(64.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    "Izinkan akses kamera untuk melanjutkan.",
                    color = usuDarkGreen,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
                )
            }
        }

        // Tombol Back
        IconButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .padding(start = 16.dp, top = 50.dp)
                .align(Alignment.TopStart)
                .background(usuGreen, shape = CircleShape) // Ubah ke usuGreen
//                .background(Color.White.copy(alpha = 0.9f), shape = CircleShape)
                .size(40.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White // Ubah ke putih
//                tint = usuGreen
            )
        }
    }
}

@Composable
fun CameraPreviewView(
    modifier: Modifier = Modifier,
    navController: NavController,
    ulosList: List<String>,
    detectedClass: MutableState<String?>
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val ulosDetector = remember { UlosDetector(context) }

    val detectionResults = remember { mutableStateOf<List<UlosDetector.Recognition>>(emptyList()) }
    val contrastColor = remember { mutableStateOf(Color.White) }

    Box(modifier = modifier.fillMaxSize()) {
        AndroidView(
            factory = { ctx ->
                val previewView = PreviewView(ctx).apply {
                    layoutParams = FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    scaleType = PreviewView.ScaleType.FILL_CENTER
                }

                val cameraProviderFuture = ProcessCameraProvider.getInstance(ctx)
                cameraProviderFuture.addListener({
                    val cameraProvider = cameraProviderFuture.get()

                    val preview = Preview.Builder().build().apply {
                        setSurfaceProvider(previewView.surfaceProvider)
                    }

                    val imageAnalysis = ImageAnalysis.Builder()
                        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                        .build()

                    imageAnalysis.setAnalyzer(
                        ContextCompat.getMainExecutor(ctx)
                    ) { imageProxy ->
                        val bitmap = imageProxy.toBitmap()
                        if (bitmap != null) {
                            val results = ulosDetector.detect(bitmap)
                            detectionResults.value = results
                            contrastColor.value = getContrastColor(bitmap)

                                // ✅ Navigasi ke detail ulos jika confidence > 85%
                            // ✅ Simpan class name jika confidence > 85%
                            val confident = results.firstOrNull { it.confidence >= 0.85f }
                            if (confident != null) {
                                detectedClass.value = confident.label
                            } else {
                                detectedClass.value = null
                            }
                        }
                        imageProxy.close()
                    }

                    cameraProvider.unbindAll()
                    cameraProvider.bindToLifecycle(
                        lifecycleOwner,
                        CameraSelector.DEFAULT_BACK_CAMERA,
                        preview,
                        imageAnalysis
                    )
                }, ContextCompat.getMainExecutor(ctx))

                previewView
            },
            modifier = Modifier.fillMaxSize()
        )

        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            detectionResults.value.forEach { result ->
                val box = result.location
                drawRect(
                    color = contrastColor.value,
                    topLeft = Offset(box.left * canvasWidth, box.top * canvasHeight),
                    size = Size(
                        (box.right - box.left) * canvasWidth,
                        (box.bottom - box.top) * canvasHeight
                    ),
                    style = Stroke(width = 4f)
                )

                drawContext.canvas.nativeCanvas.drawText(
                    "${result.label} (${(result.confidence * 100).toInt()}%)",
                    box.left * canvasWidth,
                    box.top * canvasHeight - 10,
                    Paint().apply {
                        color = android.graphics.Color.rgb(
                            (contrastColor.value.red * 255).toInt(),
                            (contrastColor.value.green * 255).toInt(),
                            (contrastColor.value.blue * 255).toInt()
                        )
                        textSize = 48f
                        isAntiAlias = true
                    }
                )
            }
        }
    }
}

// Fungsi util
fun getContrastColor(bitmap: Bitmap): Color {
    val palette = Palette.from(bitmap).generate()
    val dominantSwatch = palette.dominantSwatch
    return if (dominantSwatch != null) {
        val r = dominantSwatch.rgb shr 16 and 0xFF
        val g = dominantSwatch.rgb shr 8 and 0xFF
        val b = dominantSwatch.rgb and 0xFF

        val brightness = (0.299 * r + 0.587 * g + 0.114 * b)
        if (brightness > 180) Color.Black else Color.White
    } else {
        Color.White
    }
}