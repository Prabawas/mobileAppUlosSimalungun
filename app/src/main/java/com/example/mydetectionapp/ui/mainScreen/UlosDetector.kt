package com.example.mydetectionapp.ui.mainScreen

import android.content.Context
import android.graphics.Bitmap
import android.graphics.RectF
import org.tensorflow.lite.Interpreter
import java.nio.MappedByteBuffer
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.io.FileInputStream
import java.nio.channels.FileChannel

class UlosDetector(private val context: Context) {

    private var interpreter: Interpreter
    private val inputWidth: Int
    private val inputHeight: Int
    private val threshold = 0.5f  // Confidence threshold
    private val labels: List<String>

    init {
        val model = loadModelFile("detect_25000.tflite")
        interpreter = Interpreter(model)

        // Ambil ukuran input model dari Tensor
        val inputShape = interpreter.getInputTensor(0).shape()
        inputHeight = inputShape[1]
        inputWidth = inputShape[2]

        labels = context.assets.open("labelmap.txt").bufferedReader().readLines()
    }

    private fun loadModelFile(filename: String): MappedByteBuffer {
        val fileDescriptor = context.assets.openFd(filename)
        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
        val fileChannel = inputStream.channel
        val startOffset = fileDescriptor.startOffset
        val declaredLength = fileDescriptor.declaredLength
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
    }

    fun detect(bitmap: Bitmap): List<Recognition> {
        val inputShape = interpreter.getInputTensor(0).shape()
        val modelHeight = inputShape[1]
        val modelWidth = inputShape[2]

        val resizedBitmap = Bitmap.createScaledBitmap(bitmap, modelWidth, modelHeight, true)

        val inputBuffer = ByteBuffer.allocateDirect(4 * modelWidth * modelHeight * 3) // float32 = 4 byte
        inputBuffer.order(ByteOrder.nativeOrder())

        for (y in 0 until modelHeight) {
            for (x in 0 until modelWidth) {
                val pixel = resizedBitmap.getPixel(x, y)

                // Extract RGB
                val r = (pixel shr 16 and 0xFF).toFloat()
                val g = (pixel shr 8 and 0xFF).toFloat()
                val b = (pixel and 0xFF).toFloat()

                // Normalize seperti Python: (val - 127.5f) / 127.5f
                inputBuffer.putFloat((r - 127.5f) / 127.5f)
                inputBuffer.putFloat((g - 127.5f) / 127.5f)
                inputBuffer.putFloat((b - 127.5f) / 127.5f)
            }
        }

        val outputBoxes = Array(1) { Array(10) { FloatArray(4) } } // bounding box
        val outputClasses = Array(1) { FloatArray(10) } // class index
        val outputScores = Array(1) { FloatArray(10) } // confidence
        val numDetections = FloatArray(1)

        val inputArray = arrayOf<Any>(inputBuffer)
        val outputMap = mapOf(
            0 to outputScores,
            1 to outputBoxes,
            2 to numDetections,
            3 to outputClasses
        )

        interpreter.runForMultipleInputsOutputs(inputArray, outputMap)

        val recognitions = mutableListOf<Recognition>()
        for (i in 0 until 10) {
            val score = outputScores[0][i]
            if (score > 0.5f) {
                val labelIndex = outputClasses[0][i].toInt()
                val label = labels.getOrElse(labelIndex) { "Unknown" }
                val box = outputBoxes[0][i] // [top, left, bottom, right]

                recognitions.add(
                    Recognition(
                        label = label,
                        confidence = score,
                        location = RectF(box[1], box[0], box[3], box[2])
                    )
                )
            }
        }

        return recognitions
    }

    data class Recognition(
        val label: String,
        val confidence: Float,
        val location: RectF,
//        val boundingBox: RectF
    )



    data class DetectionResult(
        val label: String,
        val confidence: Float,
        val boundingBox: FloatArray // ymin, xmin, ymax, xmax
    )
}