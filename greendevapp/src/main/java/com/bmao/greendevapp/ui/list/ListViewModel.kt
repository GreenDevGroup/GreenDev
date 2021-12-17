package com.bmao.greendevapp.ui.list

import android.provider.Settings
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bmao.greendevapp.data.TouristicAttractionRepository
import com.bmao.greendevapp.model.TouristicAttraction
import com.bmao.greendevapp.model.TouristicAttractionItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel: ViewModel() {

    private var touristicAttractionsLoad : MutableLiveData<ArrayList<TouristicAttractionItem>> = MutableLiveData()
    val onTouristicAttractionsLoaded: LiveData<ArrayList<TouristicAttractionItem>> = touristicAttractionsLoad

    private val repository = TouristicAttractionRepository()

    fun getAttractionFromServer() {
        GlobalScope.launch(Dispatchers.IO){
        touristicAttractionsLoad.postValue(repository.getTouristicAttraction())
        }
    }

     fun loadMockJSON(touristicAttractionString: InputStream?) {
         val superHeroesString = touristicAttractionString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        touristicAttractionsLoad.value = gson.fromJson(superHeroesString, TouristicAttraction::class.java)
    }
}