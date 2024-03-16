package mx.unam.fi.randomphotoapp.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import mx.unam.fi.randomphotoapp.model.RandomPhoto
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://picsum.photos/" //"https://api.thecatapi.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface ImgApiService{
    //@GET("v1/images/search?limit=10")
    @GET("v2/list")
    suspend fun getPhotos():List<RandomPhoto>
}

object RandomPhotosApi {
    val retrofitService: ImgApiService by lazy{
        retrofit.create(ImgApiService::class.java)
    }
}