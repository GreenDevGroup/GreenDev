package com.bmao.greendevapp.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bmao.greendevapp.R
import com.bmao.greendevapp.databinding.FragmentTouristicDetailBinding
import com.squareup.picasso.Picasso

class TouristicDetailFragment : Fragment() {

    private lateinit var DetailBinding : FragmentTouristicDetailBinding
    private val args : TouristicDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        DetailBinding = FragmentTouristicDetailBinding.inflate(inflater, container, false)
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
            //Picasso.get().load(turisticAttraction.urlPicture).into(carousel)

        }
    }
}