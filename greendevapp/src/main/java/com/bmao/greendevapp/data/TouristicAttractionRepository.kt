package com.bmao.greendevapp.data

class TouristicAttractionRepository {
    suspend fun getTouristicAttraction()=ApiFactory.retrofit.getAttraction()
}