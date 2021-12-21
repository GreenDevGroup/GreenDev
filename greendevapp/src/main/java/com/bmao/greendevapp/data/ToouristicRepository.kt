package com.bmao.greendevapp.data

class ToouristicRepository {

    suspend fun getTouristic() = WebService.retrofit.getAttraction()
}