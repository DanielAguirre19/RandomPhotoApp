package mx.unam.fi.randomphotoapp.viewmmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import mx.unam.fi.randomphotoapp.network.RandomPhotosApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface ImgUIState{
    data class Success(val photos:String) : ImgUIState

    object Error:ImgUIState

    object Loading:ImgUIState
}

class RandomImgViewModel:ViewModel() {
    var imgUiState:ImgUIState by mutableStateOf(ImgUIState.Loading)
        private set

    init{
        getRandomPhotos()
    }

    fun getRandomPhotos(){
        viewModelScope.launch {
            imgUiState = try{
                val listResult = RandomPhotosApi.retrofitService.getPhotos()
                ImgUIState.Success("Número de fotos: ${listResult.size}")
            }
            catch (e:IOException){
                ImgUIState.Error
            }
        }
    }
}