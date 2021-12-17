package com.bmao.greendevapp.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bmao.greendevapp.databinding.FragmentTouristicListBinding
import com.bmao.greendevapp.ui.main.MainActivity
import com.bmao.greendevapp.model.TouristicAttractionItem


class TouristicListFragment : Fragment() {

    private var listTouristicAttractions : ArrayList<TouristicAttractionItem> = arrayListOf()
    private lateinit var listViewModel: ListViewModel
    private lateinit var listBinding : FragmentTouristicListBinding
    private lateinit var touristicsAdapter : TouristicCentresAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentTouristicListBinding.inflate(inflater, container, false)
        listViewModel= ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listViewModel.loadMockJSON(context?.assets?.open("touristAttraction.json"))

        listViewModel.onTouristicAttractionsLoaded.observe(viewLifecycleOwner, { result ->
            onTouristicAttractionsLoadedSubscribe(result)
        })

        touristicsAdapter = TouristicCentresAdapter(listTouristicAttractions, onItemClicked = {onTouristicCentreClicked(it)} )

        listBinding.resortsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = touristicsAdapter
            setHasFixedSize(false)
        }


    }

    private fun onTouristicAttractionsLoadedSubscribe(result: ArrayList<TouristicAttractionItem>?) {
        result?.let{ listTouristicAttractions ->
            touristicsAdapter.appendItems(listTouristicAttractions)

            /*this.listTouristicAttractions = listTouristicAttractionslocal
            touristicsAdapter.notifyDataSetChanged()*/
        }
    }


    private fun onTouristicCentreClicked(touristicAttraction : TouristicAttractionItem) {
        findNavController().navigate(TouristicListFragmentDirections.actionTouristicListFragmentToTouristicDetailFragment(touristicAttraction = touristicAttraction))
    }
}