package com.example.effectivemobileaviation.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.domain.model.PopularDirectionModel
import com.example.effectivemobileaviation.R
import com.example.effectivemobileaviation.databinding.FragmentSearchBinding
import com.example.effectivemobileaviation.presentation.search.adapters.directFlightsAdapter
import com.example.effectivemobileaviation.presentation.search.adapters.popularDirectionAdapter
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val args: SearchFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editTextFrom.setText(args.countryFrom)
        setOnClickListeners()
        val adapter = ListDelegationAdapter(
            directFlightsAdapter(),
            popularDirectionAdapter { binding.editTextTo.setText(it) }
        )
        adapter.items = listOf(
            PopularDirectionModel("Стамбул", 1),
            PopularDirectionModel("Сочи", 2),
            PopularDirectionModel("Пхукет", 3),
        )
        binding.searchRV.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        binding.editTextTo.requestFocus()
    }

    private fun setOnClickListeners() {
        binding.iconCross.setOnClickListener {
            binding.editTextTo.setText("")
        }

        binding.iconDifficultRoute.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_difficultRouteFragment)
        }
        binding.difficultRouteTV.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_difficultRouteFragment)
        }
        binding.iconAnywhere.setOnClickListener {
            binding.editTextTo.setText(binding.AnywhereTV.text)
        }
        binding.AnywhereTV.setOnClickListener {
            binding.editTextTo.setText(binding.AnywhereTV.text)
        }
        binding.iconWeekends.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_weekendsFragment)
        }
        binding.weekendsTV.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_weekendsFragment)
        }
        binding.iconHotTickets.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_hotTicketsFragment)
        }
        binding.hotTicketsTV.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_hotTicketsFragment)
        }
    }
}