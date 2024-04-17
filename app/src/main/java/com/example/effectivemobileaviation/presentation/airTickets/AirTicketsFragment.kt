package com.example.effectivemobileaviation.presentation.airTickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.effectivemobileaviation.databinding.FragmentAirTicketsBinding

class AirTicketsFragment : Fragment() {

    private var _binding: FragmentAirTicketsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AirTicketsViewModel by viewModel()

    private val flyAwayMusicallyAdapter by lazy { FlyAwayMusicallyAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAirTicketsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.flyAwayMusicallyItemsState.observe(viewLifecycleOwner) {
            flyAwayMusicallyAdapter.items = it
            flyAwayMusicallyAdapter.notifyDataSetChanged()
        }

        binding.flyAwayMusicallyRV.adapter = flyAwayMusicallyAdapter
    }
}