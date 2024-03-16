package mx.unam.fi.randomphotoapp.model

import kotlinx.serialization.Serializable

@Serializable
data class RandomPhoto(
    val id:String,
    val author:String,
    val width: Int,
    val height: Int,
    val url:String,
    val download_url:String

)
