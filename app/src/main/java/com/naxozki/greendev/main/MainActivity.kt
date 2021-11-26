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
        }

        //Carousel
        val carousel: ImageCarousel = findViewById(R.id.carousel)
        list.add(CarouselItem(imageDrawable = R.drawable.terracota_1, caption = "Terracota"))
        list.add(CarouselItem(imageDrawable = R.drawable.terracota_2, caption = "Terracota"))
        list.add(CarouselItem(imageDrawable = R.drawable.terracota_3, caption = "Terracota"))
        list.add(CarouselItem(imageDrawable = R.drawable.terracota_4, caption = "Terracota"))
        list.add(CarouselItem(imageDrawable = R.drawable.terracota_5, caption = "Terracota"))
        carousel.addData(list)
    }
}
