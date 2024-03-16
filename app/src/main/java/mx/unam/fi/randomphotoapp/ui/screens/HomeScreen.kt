package mx.unam.fi.randomphotoapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.unam.fi.randomphotoapp.R
import mx.unam.fi.randomphotoapp.viewmmodel.ImgUIState

@Composable

fun HomeScreen(
    imgUiState:ImgUIState,
    modifier: Modifier= Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    when(imgUiState){
        is ImgUIState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is ImgUIState.Success -> ResultScreen(photos = imgUiState.photos,
            modifier=modifier.fillMaxWidth().background(Color.LightGray))
        is ImgUIState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
    }
}

@Composable
fun ErrorScreen(modifier: Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center){
        Image(painter = painterResource(id = R.drawable.problem_solving), contentDescription = "Error")
        Text(text = "Error en la conexión")
    }
}

@Composable
fun LoadingScreen(modifier: Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center){
        Image(painter = painterResource(id = R.drawable.loading), contentDescription = "Loading")
    }
}


@Composable
fun ResultScreen(photos:String, modifier: Modifier = Modifier){
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(text = photos)
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        //HomeScreen(stringResource(R.string.placeholder_result))
    }

}
