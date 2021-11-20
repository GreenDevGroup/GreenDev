package com.naxozki.greendev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class MainActivityCocuy : AppCompatActivity() {

    //Carousel
    private val list = mutableListOf<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_cocuy)

        //Carousel
        val carousel: ImageCarousel = findViewById(R.id.carousel)
        list.add(CarouselItem(imageDrawable = R.drawable.elcocuy1, caption = "El Cocuy"))
        list.add(CarouselItem(imageDrawable = R.drawable.elcocuy2, caption = "El Cocuy"))
        list.add(CarouselItem(imageDrawable = R.drawable.elcocuy3, caption = "El Cocuy"))
        list.add(CarouselItem(imageDrawable = R.drawable.elcocuy4, caption = "El Cocuy"))
        carousel.addData(list)

    }
}