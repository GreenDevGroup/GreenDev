package com.bmao.greendevapp.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bmao.greendevapp.R
import com.bmao.greendevapp.model.TouristicAttractionItem
import com.squareup.picasso.Picasso



class TouristicCentresAdapter(

    private val centerTuristicList: ArrayList<TouristicAttractionItem>,
    private val onItemClicked:(TouristicAttractionItem)-> Unit) : RecyclerView.Adapter<TouristicCentresAdapter.ResortsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResortsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.card_view_touristiccentres_item,
            parent, false)
        return ResortsViewHolder(view)
    }



    override fun onBindViewHolder(holder: ResortsViewHolder, position: Int) {
        val centerTuristic = centerTuristicList[position]
        holder.itemView.setOnClickListener{onItemClicked(centerTuristicList[position])}
        holder.bind(centerTuristic)

    }

    override fun getItemCount(): Int {
        return centerTuristicList.size
    }

    class ResortsViewHolder(Itemview: View) : RecyclerView.ViewHolder(Itemview){

        private var TitleTextView: TextView = Itemview.findViewById(R.id.title_incardview_textview)
        private var descriptonTextView: TextView = Itemview.findViewById(R.id.description_incardview_textView)
        private var pictureImageView: ImageView = Itemview.findViewById(R.id.image_incardview_imageView)
        private var ratingView: RatingBar = Itemview.findViewById(R.id.stars_incardview_ratingBar)
        private var ratingText: TextView = Itemview.findViewById(R.id.rating_textView)


        fun bind(touristicCentre: TouristicAttractionItem){
            TitleTextView.text = touristicCentre.title
            descriptonTextView.text = touristicCentre.shortDescription
            ratingView.rating=touristicCentre.rating
            ratingText.text= touristicCentre.rating.toString()
            Picasso.get().load(touristicCentre.urlPicture).into(pictureImageView)
        }
    }
}