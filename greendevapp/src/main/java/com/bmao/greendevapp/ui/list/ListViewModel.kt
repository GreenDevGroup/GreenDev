package com.bmao.greendevapp.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bmao.greendevapp.model.TouristicAttraction
import com.bmao.greendevapp.model.TouristicAttractionItem
import com.google.gson.Gson
import java.io.InputStream

class ListViewModel: ViewModel() {

    private var touristicAttractionsLoad : MutableLiveData<ArrayList<TouristicAttractionItem>> = MutableLiveData()
    val onTouristicAttractionsLoaded: LiveData<ArrayList<TouristicAttractionItem>> = touristicAttractionsLoad

     fun loadMockJSON(touristicAttractionString: InputStream?) {
         val superHeroesString = touristicAttractionString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        touristicAttractionsLoad.value = gson.fromJson(superHeroesString, TouristicAttraction::class.java)
    }
}