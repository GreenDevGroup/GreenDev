package com.naxozki.greendev


import com.google.gson.annotations.SerializedName

data class TouristicCentresItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("schedule")
    val schedule: String,
    @SerializedName("temperature")
    val temperature: String,
    @SerializedName("titleName")
    val titleName: String,
    @SerializedName("ubication")
    val ubication: String,
    @SerializedName("urlPicture")
    val urlPicture: String
)