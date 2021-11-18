package com.naxozki.greendev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
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

        //inicializar nuestro adapter
        touristicCenterAdapter =  TouristicCentresAdapter()

        //Configurar para que funcione nuestro recycleView:

        //usted va funcionar de forma vertical
        resortsRecyclerView.addItemDecoration(
            DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

        //Seteando el adapter:
        resortsRecyclerView.adapter = touristicCenterAdapter

    }
}