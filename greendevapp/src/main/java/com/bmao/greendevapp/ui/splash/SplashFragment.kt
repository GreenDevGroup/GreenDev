package com.bmao.greendevapp.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bmao.greendevapp.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private lateinit var splashBinding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun goToListFragment() {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToTouristicListFragment())
    }


}