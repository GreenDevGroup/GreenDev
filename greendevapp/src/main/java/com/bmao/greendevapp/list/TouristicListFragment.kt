package com.bmao.greendevapp.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bmao.greendevapp.databinding.FragmentTouristicListBinding
import com.bmao.greendevapp.model.TouristicAttraction
import com.bmao.greendevapp.model.TouristicAttractionItem
import com.google.gson.Gson


class TouristicListFragment : Fragment() {

    private lateinit var listTouristicAttractions : ArrayList<TouristicAttractionItem>
    private lateinit var listBinding : FragmentTouristicListBinding
    private lateinit var touristicsAdapter : TouristicCentresAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentTouristicListBinding.inflate(inflater, container, false)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listTouristicAttractions = loadMockJSON()
        touristicsAdapter = TouristicCentresAdapter(listTouristicAttractions, onItemClicked = {onTouristicCentreClicked(it)} )
        listBinding.resortsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = touristicsAdapter
            setHasFixedSize(false)
        }
    }

    private fun loadMockJSON(): java.util.ArrayList<TouristicAttractionItem> {
        val touristicAttractionString : String = context?.assets?.open("touristAttraction.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        val data = gson.fromJson(touristicAttractionString, TouristicAttraction::class.java)
        return data
    }

    private fun onTouristicCentreClicked(touristicAttraction : TouristicAttractionItem) {
        findNavController().navigate(TouristicListFragmentDirections.actionTouristicListFragmentToTouristicDetailFragment(touristicAttraction = touristicAttraction))
    }
}