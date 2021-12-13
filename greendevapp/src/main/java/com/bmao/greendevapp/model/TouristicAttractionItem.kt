package com.bmao.greendevapp.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TouristicAttractionItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("schedule")
    val schedule: String,
    @SerializedName("shortDescription")
    val shortDescription: String,
    @SerializedName("temperature")
    val temperature: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("urlPicture")
    val urlPicture: String,
    @SerializedName("rating")
    val rating: Float,
    @SerializedName("urlPictureCoruselUno")
    val urlPictureCoruselUno: String,
    @SerializedName("urlPictureCoruselDos")
    val urlPictureCoruselDos: String,
    @SerializedName("urlPictureCoruselTres")
    val urlPictureCoruselTres: String,
    @SerializedName("urlPictureCoruselCuatro")
    val urlPictureCoruselCuatro: String,
    @SerializedName("urlPictureCoruselCinco")
    val urlPictureCoruselCinco: String,
    @SerializedName("lalitude")
    val lalitude: Double,
    @SerializedName("Logitud")
    val Logitud: Double

) : Serializable