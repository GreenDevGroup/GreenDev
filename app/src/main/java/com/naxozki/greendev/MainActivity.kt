package com.naxozki.greendev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


//Importo libreria carousel:
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel

class MainActivity : AppCompatActivity() {

    //Carousel
    private val list = mutableListOf<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
