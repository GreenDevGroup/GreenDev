package com.naxozki.greendev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class ListResortsActivity : AppCompatActivity() {

    //Una variable la debo inicializar si no lo hago, debo decirle a kotlin que no la voy a inicializar.
    private lateinit var listResorts: ArrayList<TouristicCentresItem>
    private lateinit var touristicCenterAdapter: TouristicCentresAdapter
    private lateinit var resortsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_resorts)

        //Bindeamos/unimos nuestro recyclerView
        resortsRecyclerView = findViewById(R.id.resorts_recycler_view)

        //Lista de centros turisticos
        //listResorts = createMockResorts() //Mock es una data que yo utilizo de prueba.
        listResorts=loadlistResortsFromJson()

        //inicializar nuestro adapter
        touristicCenterAdapter =  TouristicCentresAdapter(listResorts)

        /*NO FUNCIONO....Configurar para que funcione nuestro recycleView:

        //usted va funcionar de forma vertical:
        resortsRecyclerView.addItemDecoration(
        DividerItemDecoration(this,DividerItemDecoration.VERTICAL))*/

        //Este apply es una forma de asginar atributos a una clase o objeto.
        resortsRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = touristicCenterAdapter
            setHasFixedSize(false)
        }


        /*NO FUNCIONO...Seteando el adapter:
        resortsRecyclerView.adapter = touristicCenterAdapter*/

    }

    private fun loadlistResortsFromJson(): ArrayList<TouristicCentresItem> {
        //Convierte el json en un Strin super largo.
        val listResortsString: String = applicationContext.assets.open("TouristicCentres.json").bufferedReader().use { it.readText() }
        //
        val gson= Gson()
        val data = gson.fromJson(listResortsString,TouristicCentres::class.java)
        return data
    }

    /*private fun createMockResorts() : ArrayList<TouristicCentres>{
        return arrayListOf(
            TouristicCentres(
                titleName="Casa Terracota",
                description="Caso de barro",
                temperature="25 °C",
                ubication="Boyaca",
                schedule="10AM - 6PM",
                urlPicture = "https://res.cloudinary.com/naxozki/image/upload/v1637453474/terracota_cardview_yugz7j.jpg"
            ),
            TouristicCentres(
                titleName="Puente Boyaca",
                description="Es un puenta xd",
                temperature="20 °C",
                ubication="Boyaca",
                schedule="4PM - 8PM",
                urlPicture = "https://res.cloudinary.com/naxozki/image/upload/v1637454304/5a04f217e8f08_1_cfoj8q.jpg"
            ),
            TouristicCentres(
                titleName="Nevado del Cocuy",
                description="Este parque es de las reservas hidrográficas más importantes de Colombia, porque alimenta los llanos orientales",
                temperature="-20°C y 4°C",
                ubication="Boyaca",
                schedule="6am - 5pm",
                urlPicture = "https://res.cloudinary.com/naxozki/image/upload/v1637454037/elcocuy1_jmrwoo.jpg"
            ),
            TouristicCentres(
                titleName="Pantano de vargas",
                description="Esta sucio",
                temperature="30 °C",
                ubication="Boyaca",
                schedule="12pm - 4pm",
                urlPicture = "https://res.cloudinary.com/naxozki/image/upload/v1637454234/pnatano_vargas_wt1vuy.jpg"
            ),
            TouristicCentres(
                titleName="Laguna de TOTA",
                description="Es una laguna",
                temperature="35 °C",
                ubication="Boyaca",
                schedule="10am - 4pm",
                urlPicture = "https://res.cloudinary.com/naxozki/image/upload/v1637454427/planes-turisticos-laguna-de-tota_1_edaygu.jpg"
            )
        )

    }*/

}