package com.khudyakov.carstore.data.storage

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StorageManager @Inject constructor(@ApplicationContext private val context: Context) {

    suspend fun saveToInternalStorage(imageUri: Uri): File {
        val fileName = "${System.currentTimeMillis()}.jpg"
        val destinationFile = File(context.filesDir, fileName)

        withContext(Dispatchers.IO) {
            val bitmap = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                val source = ImageDecoder.createSource(context.contentResolver, imageUri)
                ImageDecoder.decodeBitmap(source)
            } else {
                @Suppress("DEPRECATION")
                MediaStore.Images.Media.getBitmap(context.contentResolver, imageUri)
            }
            bitmap.compress(Bitmap.CompressFormat.JPEG, 10, destinationFile.outputStream())
        }

        return destinationFile
    }
}
