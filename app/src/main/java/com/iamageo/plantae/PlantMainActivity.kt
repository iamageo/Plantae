package com.iamageo.plantae

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iamageo.plantae.ui.screens.home.PlantaeHomeScreen

class PlantMainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = PlantaeScreens.PlantHomeScreen.route
            ) {
                composable(route = PlantaeScreens.PlantHomeScreen.route) {
                    PlantaeHomeScreen(navController = navController)
                }
            }


        }
    }
}

/*
       private lateinit var outputDirectory: File
       private lateinit var cameraExecutor: ExecutorService

       private var shouldShowCamera: MutableState<Boolean> = mutableStateOf(false)

       private lateinit var photoUri: Uri
       private var shouldShowPhoto: MutableState<Boolean> = mutableStateOf(false)

       private val requestPermissionLauncher = registerForActivityResult(
           ActivityResultContracts.RequestPermission()
       ) { isGranted ->
           if (isGranted) {
               Log.i("Geovani -->", "permission granted")
               shouldShowCamera.value = true // 👈🏽
           } else {
               Log.i("Geovani -->", "permission denied")
           }
       }

       .
       .
       .
       if (shouldShowCamera.value) {
           CameraView(
               outputDirectory = outputDirectory,
               executor = cameraExecutor,
               onImageCaptured = ::handleImageCapture,
               onError = { Log.e("Geovani -->", "View error:", it) }
           )
       }
       if (shouldShowPhoto.value) {
           Image(
               painter = rememberImagePainter(photoUri),
               contentDescription = null,
               modifier = Modifier.fillMaxSize()
           )
       }

       }

       requestCameraPermission()

       outputDirectory = getOutputDirectory()
       cameraExecutor = Executors.newSingleThreadExecutor()

       .
       .
       .

        private fun requestCameraPermission() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                Log.i("Geovani -->", "Permission previously granted")
                shouldShowCamera.value = true
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.CAMERA
            ) -> Log.i("Geovani -->", "Show camera permissions dialog")

            else -> requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
        }

        private fun handleImageCapture(uri: Uri) {
        Log.i("Geovani -->", "Image captured: $uri")
        shouldShowCamera.value = false
        photoUri = uri
        shouldShowPhoto.value = true
        }

        private fun getOutputDirectory(): File {
        val mediaDir = externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
        }

        return if (mediaDir != null && mediaDir.exists()) mediaDir else filesDir
        }

        override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
        }

 */
