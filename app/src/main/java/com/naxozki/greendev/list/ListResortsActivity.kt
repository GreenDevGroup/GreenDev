package com.naxozki.greendev.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.naxozki.greendev.R
import com.naxozki.greendev.main.MainActivity
import com.naxozki.greendev.model.TouristicAttraction
import com.naxozki.greendev.model.TouristicAttractionItem

class ListResortsActivity : AppCompatActivity() {

    //Una variable la debo inicializar si no lo hago, debo decirle a kotlin que no la voy a inicializar.
    private lateinit var listResorts: ArrayList<TouristicAttractionItem>
    private lateinit var touristicCenterAdapter: TouristicCentresAdapter
    private lateinit var resortsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_resorts)

        resortsRecyclerView = findViewById(R.id.resorts_recycler_view)

        listResorts = loadMockJSON()
        touristicCenterAdapter =  TouristicCentresAdapter(listResorts, onItemClicked = {onTuristicCentreClicked(it)})

        resortsRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = touristicCenterAdapter
            setHasFixedSize(false)
        }
    }

    private fun onTuristicCentreClicked(turisticAttraction : TouristicAttractionItem){
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("touristicAttraction", turisticAttraction)
        startActivity(intent)
    }

    private fun loadMockJSON(): ArrayList<TouristicAttractionItem> {
        val touristicAttractionString : String = applicationContext.assets.open("touristAttraction.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(touristicAttractionString, TouristicAttraction::class.java)
        return data

    }

    /*private fun createMockResorts() : ArrayList<TouristicCentres>{
        return arrayListOf(
            TouristicCentres(
                titleName="Casa Terracota",
                description="Caso de barro",
                temperature="25 °C",
                ubication="Boyaca",
                schedule="10AM - 6PM"
            ),
            TouristicCentres(
                titleName="Puente Boyaca",
                description="Es un puenta xd",
                temperature="20 °C",
                ubication="Boyaca",
                schedule="4PM - 8PM"
            ),
            TouristicCentres(
                titleName="Nevado del Cocuy",
                description="Este  parque es de las  reservas hidrográficas más importantes de Colombia, porque alimenta los llanos orientales",
                temperature="-20°C y 4°C",
                ubication="Boyaca",
                schedule="6am - 5pm"
            ),
            TouristicCentres(
                titleName="Pantano de vargas",
                description="Esta sucio",
                temperature="30 °C",
                ubication="Boyaca",
                schedule="12pm - 4pm"
            ),
            TouristicCentres(
                titleName="Laguna de TOTA",
                description="Es una laguna",
                temperature="35 °C",
                ubication="Boyaca",
                schedule="10am - 4pm"
            )
        )

    }*/

}