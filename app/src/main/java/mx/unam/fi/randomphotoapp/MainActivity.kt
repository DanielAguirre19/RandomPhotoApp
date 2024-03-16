package mx.unam.fi.randomphotoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import mx.unam.fi.randomphotoapp.ui.RImgApp
import mx.unam.fi.randomphotoapp.ui.theme.RandomPhotoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomPhotoAppTheme {
                //Initial App without Model
                RImgApp()
            }
        }
    }
}