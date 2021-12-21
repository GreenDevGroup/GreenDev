package com.bmao.greendevapp.ui.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bmao.greendevapp.R
import com.bmao.greendevapp.databinding.FragmentTouristicDetailBinding
import com.bmao.greendevapp.ui.detail.TouristicDetailFragmentArgs
import com.bmao.greendevapp.ui.detail.TouristicDetailFragmentDirections
import com.bmao.greendevapp.ui.ui.main.MainActivity
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel


class TouristicDetailFragment : Fragment() {
    private lateinit var DetailBinding : FragmentTouristicDetailBinding
    private lateinit var tourdetailViewModel: TouristicDetailViewModel
    private val args : TouristicDetailFragmentArgs by navArgs()
    private val list = mutableListOf<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        DetailBinding = FragmentTouristicDetailBinding.inflate(inflater, container, false)
        tourdetailViewModel = ViewModelProvider(this).get(TouristicDetailViewModel::class.java)
        return DetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val turisticAttraction = args.touristicAttraction
        with(DetailBinding){
            titleTextView.text = turisticAttraction.title
            descriptionTextView.text = turisticAttraction.description
            temperatureTextView.text = turisticAttraction.temperature
            locationTextView.text = turisticAttraction.location
            scheduleTextView.text = turisticAttraction.schedule

            //Carousel
            val carousel: ImageCarousel = view.findViewById(R.id.carousel)
            list.add(CarouselItem(imageUrl = turisticAttraction.urlPictureCoruselUno, caption = turisticAttraction.title))
            list.add(CarouselItem(imageUrl = turisticAttraction.urlPictureCoruselDos, caption = turisticAttraction.title))
            list.add(CarouselItem(imageUrl = turisticAttraction.urlPictureCoruselTres, caption = turisticAttraction.title))
            list.add(CarouselItem(imageUrl = turisticAttraction.urlPictureCoruselCuatro, caption = turisticAttraction.title))
            list.add(CarouselItem(imageUrl = turisticAttraction.urlPictureCoruselCinco, caption = turisticAttraction.title))
            carousel.addData(list)

            mapButton.setOnClickListener {
                findNavController().navigate(TouristicDetailFragmentDirections.actionTouristicDetailFragmentToMapsFragment(turisticAttraction))
            }

        }
    }
}