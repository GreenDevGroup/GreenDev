package com.naxozki.greendev


import com.google.gson.annotations.SerializedName

data class TouristAttractionsItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("schedule")
    val schedule: String,
    @SerializedName("temperature")
    val temperature: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("urlPicture")
    val urlPicture: String
)