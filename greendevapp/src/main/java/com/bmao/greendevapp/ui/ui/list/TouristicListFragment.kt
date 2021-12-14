package com.bmao.greendevapp.ui.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bmao.greendevapp.databinding.FragmentTouristicListBinding
import com.bmao.greendevapp.ui.ui.main.MainActivity
import com.bmao.greendevapp.model.TouristicAttractionItem


class TouristicListFragment : Fragment() {

    private lateinit var listBinding : FragmentTouristicListBinding
    private lateinit var listViewModel: TouristicListViewModel
    private lateinit var touristicsAdapter : TouristicCentresAdapter
    private var listTouristicAttractions : ArrayList<TouristicAttractionItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentTouristicListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[TouristicListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        //listTouristicAttractions = loadMockJSON()

        //listViewModel.loadMockHistoriaFromJson(context?.assets?.open("touristAttraction.json"))

        listViewModel.getTouristicFromServer()

        listViewModel.onHistoriaLoaded.observe(viewLifecycleOwner, { result ->
            onHistoriaLoadedSubscribe(result)
        })

        touristicsAdapter = TouristicCentresAdapter(listTouristicAttractions, onItemClicked = {onTouristicCentreClicked(it)} )
        listBinding.resortsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = touristicsAdapter
            setHasFixedSize(false)
        }
    }

    private fun onHistoriaLoadedSubscribe(result: ArrayList<TouristicAttractionItem>?) {
        result?.let{ lishistoria ->
            touristicsAdapter.appendItems(lishistoria)

        }

    }
/*
    private fun loadMockJSON(): java.util.ArrayList<TouristicAttractionItem> {
        val touristicAttractionString : String = context?.assets?.open("touristAttraction.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        val data = gson.fromJson(touristicAttractionString, TouristicAttraction::class.java)
        return data
    }*/

    private fun onTouristicCentreClicked(touristicAttraction : TouristicAttractionItem) {
        findNavController().navigate(TouristicListFragmentDirections.actionTouristicListFragmentToTouristicDetailFragment(touristicAttraction = touristicAttraction))
    }
}