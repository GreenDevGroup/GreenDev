package com.naxozki.greendev.model


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
    val urlPicture: String
) : Serializable