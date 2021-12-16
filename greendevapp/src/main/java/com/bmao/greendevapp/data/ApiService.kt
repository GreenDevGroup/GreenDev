package com.bmao.greendevapp.data

import com.bmao.greendevapp.model.TouristicAttraction
import retrofit2.http.GET

interface ApiService {
    @GET("GreenDevGroup/GreenDev/SitiosTuristicos")
    suspend fun getSitios(): TouristicAttraction
}