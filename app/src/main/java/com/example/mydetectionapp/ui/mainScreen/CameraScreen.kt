package com.example.mydetectionapp.ui.mainScreen

import android.Manifest
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageFormat
import android.graphics.Matrix
import android.graphics.Rect
import android.graphics.YuvImage
import android.media.Image
import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import android.widget.Toast
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import com.example.mydetectionapp.ui.mainScreen.ulosDetail.ulosListData
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.task.vision.detector.ObjectDetector
import java.io.ByteArrayOutputStream
import java.util.concurrent.Executors


//@OptIn(ExperimentalPermissionsApi::class)
//@Composable
//fun CameraScreen(navController: NavController) {
//    val context = LocalContext.current
//    val permissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)
//
//    val usuGreen = Color(0xFF008577)
//    val usuDarkGreen = Color(0xFF004D40)
//    val lightBackground = Color(0xFFE5F5FF)
//
//    LaunchedEffect(Unit) {
//        if (!permissionState.status.isGranted) {
//            permissionState.launchPermissionRequest()
//        }
//    }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(lightBackground)
//    ) {
//        if (permissionState.status.isGranted) {
//            // Kotak kamera 2/3 layar
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .fillMaxHeight(2f / 3f)
//                    .align(Alignment.TopCenter)
//            ) {
//                CameraPreviewView(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(16.dp) // Padding di semua sisi kamera
//                )
//            }
//        } else {
//            // Kalau belum ada izin kamera
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(horizontal = 24.dp),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Icon(
//                    imageVector = Icons.Default.CameraAlt,
//                    contentDescription = "Camera Icon",
//                    tint = usuGreen,
//                    modifier = Modifier.size(64.dp)
//                )
//
//                Spacer(modifier = Modifier.height(16.dp))
//
//                Text(
//                    "Izinkan akses kamera untuk melanjutkan.",
//                    color = usuDarkGreen,
//                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
//                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = androidx.compose.ui.text.font.FontWeight.Medium)
//                )
//            }
//        }
//
//        // Tombol back di pojok kiri atas
//        IconButton(
//            onClick = {
//                navController.popBackStack()
//            },
//            modifier = Modifier
//                .padding(start = 16.dp, top = 50.dp)
//                .align(Alignment.TopStart)
//                .background(Color.White.copy(alpha = 0.9f), shape = CircleShape)
//                .size(40.dp)
//        ) {
//            Icon(
//                imageVector = Icons.Default.ArrowBack,
//                contentDescription = "Back",
//                tint = usuGreen
//            )
//        }
//
//        // Tombol Deteksi di bagian bawah layar
//        Button(
//            onClick = {
//                Toast.makeText(context, "Simulasi deteksi ulos dilakukan!", Toast.LENGTH_SHORT).show()
//                // TODO: Ganti ini nanti dengan logika pemanggilan model
//                // Simulasi deteksi kain ulos Bittang Maratur (index ke-0)
//                navController.navigate("ulos_detail/0")
//            },
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .padding(24.dp)
//                .fillMaxWidth(0.85f),
//            colors = ButtonDefaults.buttonColors(containerColor = usuDarkGreen)
//        ) {
//            Text(
//                text = "Deteksi Sekarang",
//                color = Color.White,
//                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
//            )
//        }
//    }
//}
//
//@Composable
//fun CameraPreviewView(modifier: Modifier = Modifier) {
//    val context = LocalContext.current
//    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
//
//    AndroidView(
//        factory = { ctx ->
//            val previewView = PreviewView(ctx).apply {
//                layoutParams = FrameLayout.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.MATCH_PARENT
//                )
//                scaleType = PreviewView.ScaleType.FILL_CENTER
//            }
//
//            val cameraProviderFuture = ProcessCameraProvider.getInstance(ctx)
//            cameraProviderFuture.addListener({
//                val cameraProvider = cameraProviderFuture.get()
//
//                val preview = Preview.Builder().build().also {
//                    it.setSurfaceProvider(previewView.surfaceProvider)
//                }
//
//                val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
//
//                try {
//                    cameraProvider.unbindAll()
//                    cameraProvider.bindToLifecycle(
//                        lifecycleOwner,
//                        cameraSelector,
//                        preview
//                    )
//                } catch (e: Exception) {
//                    Log.e("CameraPreview", "Gagal binding kamera", e)
//                }
//
//            }, ContextCompat.getMainExecutor(ctx))
//
//            previewView
//        },
//        modifier = modifier
//    )
//}


//@OptIn(ExperimentalPermissionsApi::class)
//@Composable
//fun CameraScreen(navController: NavController) {
//    val context = LocalContext.current
//    val permissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)
//
//    val usuGreen = Color(0xFF008577)
//    val usuDarkGreen = Color(0xFF004D40)
//    val lightBackground = Color(0xFFE5F5FF)
//
//    LaunchedEffect(Unit) {
//        if (!permissionState.status.isGranted) {
//            permissionState.launchPermissionRequest()
//        }
//    }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(lightBackground)
//    ) {
//        if (permissionState.status.isGranted) {
//            // Kotak kamera 2/3 layar
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .fillMaxHeight(2f / 3f)
//                    .align(Alignment.TopCenter)
//            ) {
//                CameraPreviewView(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(16.dp) // Padding di semua sisi kamera
//                )
//            }
//        } else {
//            // Kalau belum ada izin kamera
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(horizontal = 24.dp),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Icon(
//                    imageVector = Icons.Default.CameraAlt,
//                    contentDescription = "Camera Icon",
//                    tint = usuGreen,
//                    modifier = Modifier.size(64.dp)
//                )
//
//                Spacer(modifier = Modifier.height(16.dp))
//
//                Text(
//                    "Izinkan akses kamera untuk melanjutkan.",
//                    color = usuDarkGreen,
//                    textAlign = TextAlign.Center,
//                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
//                )
//            }
//        }
//
//        // Tombol back di pojok kiri atas
//        IconButton(
//            onClick = {
//                navController.popBackStack()
//            },
//            modifier = Modifier
//                .padding(start = 16.dp, top = 50.dp)
//                .align(Alignment.TopStart)
//                .background(Color.White.copy(alpha = 0.9f), shape = CircleShape)
//                .size(40.dp)
//        ) {
//            Icon(
//                imageVector = Icons.Default.ArrowBack,
//                contentDescription = "Back",
//                tint = usuGreen
//            )
//        }
//    }
//}
//@Composable
//fun CameraPreviewView(modifier: Modifier = Modifier) {
//    val context = LocalContext.current
//    val lifecycleOwner = LocalLifecycleOwner.current
//
//    AndroidView(
//        factory = { ctx ->
//            val previewView = PreviewView(ctx).apply {
//                layoutParams = FrameLayout.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.MATCH_PARENT
//                )
//                scaleType = PreviewView.ScaleType.FILL_CENTER
//            }
//
//            val cameraProviderFuture = ProcessCameraProvider.getInstance(ctx)
//            cameraProviderFuture.addListener({
//                val cameraProvider = cameraProviderFuture.get()
//
//                val preview = Preview.Builder().build().also {
//                    it.setSurfaceProvider(previewView.surfaceProvider)
//                }
//
//                val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
//
//                try {
//                    cameraProvider.unbindAll()
//                    cameraProvider.bindToLifecycle(
//                        lifecycleOwner,
//                        cameraSelector,
//                        preview
//                    )
//                } catch (e: Exception) {
//                    Log.e("CameraPreview", "Gagal binding kamera", e)
//                }
//
//            }, ContextCompat.getMainExecutor(ctx))
//
//            previewView
//        },
//        modifier = modifier // ini pakai modifier yang dikirim dari luar
//    )
//}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraScreen(navController: NavController) {
    val context = LocalContext.current
    val permissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)

    val usuGreen = Color(0xFF008577)
    val usuDarkGreen = Color(0xFF004D40)
    val lightBackground = Color(0xFFE5F5FF)

    var detectedLabel by remember { mutableStateOf<String?>(null) }

    val detector = remember {
        mutableStateOf<ObjectDetector?>(null)
    }

    // Load model saat pertama kali
    LaunchedEffect(Unit) {
        if (!permissionState.status.isGranted) {
            permissionState.launchPermissionRequest()
        }

        val options = ObjectDetector.ObjectDetectorOptions.builder()
            .setMaxResults(1)
            .setScoreThreshold(0.5f)
            .build()

        try {
            detector.value = ObjectDetector.createFromFileAndOptions(
                context,
                "detect.tflite", // Pastikan file model ada di assets
                options
            )
        } catch (e: Exception) {
            Log.e("TFLite", "Gagal load model: ${e.message}")
        }
    }

    // Navigasi otomatis kalau label terdeteksi
    LaunchedEffect(detectedLabel) {
        detectedLabel?.let { label ->
            val index = ulosListData.indexOfFirst { it.name.contains(label, ignoreCase = true) }
            if (index != -1) {
                navController.navigate("ulosDetail/$index")
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightBackground)
    ) {
        if (permissionState.status.isGranted) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(2f / 3f)
                    .align(Alignment.TopCenter)
            ) {
                CameraPreviewViewWithDetection(
                    detector = detector.value,
                    onObjectDetected = { label ->
                        detectedLabel = label
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }
        } else {
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

        IconButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .padding(start = 16.dp, top = 50.dp)
                .align(Alignment.TopStart)
                .background(Color.White.copy(alpha = 0.9f), shape = CircleShape)
                .size(40.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = usuGreen
            )
        }
    }
}

@Composable
fun CameraPreviewViewWithDetection(
    detector: ObjectDetector?,
    onObjectDetected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

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

                val preview = Preview.Builder().build().also {
                    it.setSurfaceProvider(previewView.surfaceProvider)
                }


//               test model model

//                val imageAnalysis = ImageAnalysis.Builder()
//                    .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
//                    .build()
//                    .also {
//                        analysis ->
//                            analysis.setAnalyzer(Executors.newSingleThreadExecutor()) { imageProxy ->
//                                processImageProxy(detector, imageProxy, onObjectDetected) }
//                    }
                val imageAnalyzer = ImageAnalysis.Builder()
                    .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                    .build()
                    .also {
                        it.setAnalyzer(ContextCompat.getMainExecutor(context)) { imageProxy ->
                            processImageProxy(detector, imageProxy, onObjectDetected = { label ->
                                Log.d("Detected", "Hasil deteksi: $label")
                                // Bisa arahkan ke halaman ulos di sini juga
                            })
                        }
                    }

                val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

                try {
                    cameraProvider.unbindAll()
                    cameraProvider.bindToLifecycle(
                        lifecycleOwner,
                        cameraSelector,
                        preview,
                        imageAnalyzer
//                        imageAnalysis
                    )
                } catch (e: Exception) {
                    Log.e("CameraPreview", "Gagal binding kamera", e)
                }

            }, ContextCompat.getMainExecutor(ctx))

            previewView
        },
        modifier = modifier
    )
}

fun processImageProxy(
    detector: ObjectDetector?,
    imageProxy: ImageProxy,
    onObjectDetected: (String) -> Unit

) {
    try {
        val mediaImage = imageProxy.image
        if (mediaImage != null && detector != null) {
            val rotationDegrees = imageProxy.imageInfo.rotationDegrees
            val bitmap = mediaImage.toBitmap()
            val rotatedBitmap = bitmap.rotate(rotationDegrees)

            val tfImage = TensorImage.fromBitmap(rotatedBitmap)

            val results = detector.detect(tfImage)

            // ✅ Tambahan logging hasil deteksi
            if (results.isNotEmpty()) {
                val label = results[0].categories.firstOrNull()?.label
                Log.d("Deteksi", "Label terdeteksi: $label") // ✅ Di sini kita tahu deteksi jalan
                label?.let { onObjectDetected(it) }
            } else {
                Log.d("Deteksi", "Tidak ada objek terdeteksi.") // ✅ Tambahan kalau hasil kosong
            }
        }
    } catch (e: Exception) {
        Log.e("TFLite", "Deteksi error: ${e.message}")
    } finally {
        imageProxy.close()
    }
}


// Konversi dari Image ke Bitmap
fun Image.toBitmap(): Bitmap {
    val yBuffer = planes[0].buffer
    val uBuffer = planes[1].buffer
    val vBuffer = planes[2].buffer

    val ySize = yBuffer.remaining()
    val uSize = uBuffer.remaining()
    val vSize = vBuffer.remaining()

    val nv21 = ByteArray(ySize + uSize + vSize)

    yBuffer.get(nv21, 0, ySize)
    vBuffer.get(nv21, ySize, vSize)
    uBuffer.get(nv21, ySize + vSize, uSize)

    val yuvImage = YuvImage(nv21, ImageFormat.NV21, width, height, null)
    val out = ByteArrayOutputStream()
    yuvImage.compressToJpeg(Rect(0, 0, width, height), 100, out)
    val yuv = out.toByteArray()
    return BitmapFactory.decodeByteArray(yuv, 0, yuv.size)
}

// Rotate bitmap sesuai orientasi kamera
fun Bitmap.rotate(degrees: Int): Bitmap {
    val matrix = Matrix().apply { postRotate(degrees.toFloat()) }
    return Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
}




























































































//@OptIn(ExperimentalPermissionsApi::class)
//@Composable
//fun CameraScreen(navController: NavController) {
//    val context = LocalContext.current
//    val permissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)
//
//    val usuGreen = Color(0xFF008577)
//    val usuDarkGreen = Color(0xFF004D40)
//    val lightBackground = Color(0xFFE5F5FF)
//
//    LaunchedEffect(Unit) {
//        if (!permissionState.status.isGranted) {
//            permissionState.launchPermissionRequest()
//        }
//    }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(lightBackground)
//    ) {
//        if (permissionState.status.isGranted) {
//            CameraPreviewView()
//        } else {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(horizontal = 24.dp),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Icon(
//                    imageVector = Icons.Default.CameraAlt,
//                    contentDescription = "Camera Icon",
//                    tint = usuGreen,
//                    modifier = Modifier.size(64.dp)
//                )
//
//                Spacer(modifier = Modifier.height(16.dp))
//
//                Text(
//                    "Izinkan akses kamera untuk melanjutkan.",
//                    color = usuDarkGreen,
//                    textAlign = TextAlign.Center,
//                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
//                )
//            }
//        }
//
//        // Tombol Back di pojok kiri atas
//        IconButton(
//            onClick = {
//                navController.popBackStack()
//            },
//            modifier = Modifier
//                .padding(start = 16.dp, top = 50.dp) // Ini dia bro, diturunkan sedikit
//                .align(Alignment.TopStart)
//                .background(Color.White.copy(alpha = 0.9f), shape = CircleShape)
//                .size(40.dp)
//        ) {
//            Icon(
//                imageVector = Icons.Default.ArrowBack,
//                contentDescription = "Back",
//                tint = usuGreen
//            )
//        }
//    }
//}

//@Composable
//fun CameraPreviewView() {
//    val context = LocalContext.current
//    val lifecycleOwner = LocalLifecycleOwner.current
//
//    AndroidView(
//        factory = { ctx ->
//            val previewView = PreviewView(ctx).apply {
//                layoutParams = FrameLayout.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.MATCH_PARENT
//                )
//                scaleType = PreviewView.ScaleType.FILL_CENTER
//            }
//
//            val cameraProviderFuture = ProcessCameraProvider.getInstance(ctx)
//            cameraProviderFuture.addListener({
//                val cameraProvider = cameraProviderFuture.get()
//
//                val preview = Preview.Builder().build().also {
//                    it.setSurfaceProvider(previewView.surfaceProvider)
//                }
//
//                val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
//
//                try {
//                    cameraProvider.unbindAll()
//                    cameraProvider.bindToLifecycle(
//                        lifecycleOwner,
//                        cameraSelector,
//                        preview
//                    )
//                } catch (e: Exception) {
//                    Log.e("CameraPreview", "Gagal binding kamera", e)
//                }
//
//            }, ContextCompat.getMainExecutor(ctx))
//
//            previewView
//        },
//        modifier = Modifier.fillMaxSize()
//    )
//}