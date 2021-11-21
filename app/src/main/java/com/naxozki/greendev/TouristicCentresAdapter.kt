package com.naxozki.greendev

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


//viewHolder= gestiona el contenido del aviso, ej: a este titulo pongale esto. etc
//Esta clase debe implementar 3 metodos adicionales "override"
//Tambien la clase se le debe pasar una lista de los centros turisticos
//hereda del adapter y le paso el viewHolder
class TouristicCentresAdapter(
    private val centerTuristicList: ArrayList<TouristAttractionsItem>
    ) : RecyclerView.Adapter<TouristicCentresAdapter.ResortsViewHolder>() {


    //Digame cual es el view en el que yo voy a colocar los items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ResortsViewHolder {
        //Este codigo es el mismo siempre, solo hay que pasarle el card_view.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_touristiccentres_item,
            parent, false)
        return ResortsViewHolder(view) //Este view es un acceso directo a el layout del card_view_touristiccentres_item
    }


    //Este metodo se va invocar cuantas veces , dependiendo del tamaño de la lista
    // (ese tamaño de la lista lo adquiero mediante el metodo override fun getItemCount():)

    //Recibe un viewHolder y una posicion
    //Yo tengo una lista esa lista la recorremos item por item, esto se hace automaticamente, mediante un obj
    override fun onBindViewHolder(holder: ResortsViewHolder, position: Int) {
        //centerTuristicList es el arraylis de el archivo TouristicCentres
        val centerTuristic = centerTuristicList[position]
        //Se lo mando a una funcion
        holder.bind(centerTuristic) //Aqui debo definir la funcion bind en la clase ViewHolder

    }


    //Me determina el tamaño de la lista
    override fun getItemCount(): Int {
        return centerTuristicList.size
    }


    //AQUI ES DONDE VOY APUNTAR:
    //recibe un vista y herada un Recyclerview que recibe otro paremetro:
    class ResortsViewHolder(Itemview: View) : RecyclerView.ViewHolder(Itemview){

        private var TitleTextView: TextView = Itemview.findViewById(R.id.title_incardview_textview)
        private var descriptonTextView: TextView = Itemview.findViewById(R.id.description_incardview_textView)
        private var pictureImageView: ImageView = Itemview.findViewById(R.id.image_incardview_imageView)

        //Defino la funcion bind que recibe un parametro.
        fun bind(touristicCentre:TouristAttractionsItem){ //Defino una variable touristicCentres de tipo TouristicCentres
            TitleTextView.text = touristicCentre.title
            descriptonTextView.text = touristicCentre.description
            Picasso.get().load(touristicCentre.urlPicture).into(pictureImageView)
        }
    }
}