package com.bmao.greendevapp.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TouristicAttractionItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("location")
    val location: String,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("rating")
    val rating: String,
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
    @SerializedName("urlPictureCoruselCinco")
    val urlPictureCoruselCinco: String,
    @SerializedName("urlPictureCoruselCuatro")
    val urlPictureCoruselCuatro: String,
    @SerializedName("urlPictureCoruselDos")
    val urlPictureCoruselDos: String,
    @SerializedName("urlPictureCoruselTres")
    val urlPictureCoruselTres: String,
    @SerializedName("urlPictureCoruselUno")
    val urlPictureCoruselUno: String
) : Serializable