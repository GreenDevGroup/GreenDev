package com.naxozki.greendev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListResortsActivity : AppCompatActivity() {

    //Una variable la debo inicializar si no lo hago, debo decirle a kotlin que no la voy a inicializar.
    private lateinit var listResorts: ArrayList<TouristicCentres>
    private lateinit var touristicCenterAdapter: TouristicCentresAdapter
    private lateinit var resortsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_resorts)

        //Bindeamos/unimos nuestro recyclerView
        resortsRecyclerView = findViewById(R.id.resorts_recycler_view)

        //Lista de centros turisticos
        listResorts = createMockResorts() //Mock es una data que yo utilizo de prueba.

        //inicializar nuestro adapter
        touristicCenterAdapter =  TouristicCentresAdapter(listResorts)

        /*NO FUNCIONO....Configurar para que funcione nuestro recycleView:

        //usted va funcionar de forma vertical:
        resortsRecyclerView.addItemDecoration(
        DividerItemDecoration(this,DividerItemDecoration.VERTICAL))*/


        resortsRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = touristicCenterAdapter
            setHasFixedSize(false)
        }


        /*NO FUNCIONO...Seteando el adapter:
        resortsRecyclerView.adapter = touristicCenterAdapter*/

    }

    private fun createMockResorts() : ArrayList<TouristicCentres>{
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

    }

}