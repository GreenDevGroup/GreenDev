package com.naxozki.greendev.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naxozki.greendev.R
import com.naxozki.greendev.databinding.ActivityMainBinding
import com.naxozki.greendev.model.TouristicAttractionItem
//Importo libreria carousel:
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel

class MainActivity : AppCompatActivity() {

    //Carousel
    private val list = mutableListOf<CarouselItem>()
    private lateinit var mainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)


        val turisticAttraction : TouristicAttractionItem = intent.extras?.getSerializable("touristicAttraction") as TouristicAttractionItem
        with(mainBinding){
            titleTextView.text = turisticAttraction.title
            descriptionTextView.text = turisticAttraction.description
            temperatureTextView.text = turisticAttraction.temperature
            locationTextView.text = turisticAttraction.location
            scheduleTextView.text = turisticAttraction.schedule

            //Carousel
            val carousel: ImageCarousel = findViewById(R.id.carousel)
            list.add(CarouselItem(imageUrl = turisticAttraction.urlPictureCoruselUno, caption = "Terracota"))
            list.add(CarouselItem(imageUrl = turisticAttraction.urlPictureCoruselDos, caption = "Terracota"))
            list.add(CarouselItem(imageUrl = turisticAttraction.urlPictureCoruselTres, caption = "Terracota"))
            list.add(CarouselItem(imageUrl = turisticAttraction.urlPictureCoruselCuatro, caption = "Terracota"))
            list.add(CarouselItem(imageUrl = turisticAttraction.urlPictureCoruselCinco, caption = "Terracota"))
            carousel.addData(list)
        }


    }
}
