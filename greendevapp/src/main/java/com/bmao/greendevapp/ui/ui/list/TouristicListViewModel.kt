package com.bmao.greendevapp.ui.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bmao.greendevapp.data.ToouristicRepository
import com.bmao.greendevapp.model.TouristicAttraction
import com.bmao.greendevapp.model.TouristicAttractionItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class TouristicListViewModel: ViewModel() {

    private var historiaLoad: MutableLiveData<ArrayList<TouristicAttractionItem>> = MutableLiveData()
    val onHistoriaLoaded: LiveData<ArrayList<TouristicAttractionItem>> = historiaLoad

    private val repository = ToouristicRepository()

    fun getTouristicFromServer(){
        GlobalScope.launch(Dispatchers.IO){
            historiaLoad.postValue(repository.getTouristic())
        }
    }


    fun loadMockHistoriaFromJson(historiasString: InputStream?){
        val historiaString = historiasString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        historiaLoad.value = gson.fromJson(historiaString, TouristicAttraction::class.java)

    }
}