package com.example.effectivemobileaviation.presentation.allTickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.effectivemobileaviation.databinding.FragmentAllTicketsBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class AllTicketsFragment : Fragment() {

    private var _binding: FragmentAllTicketsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AllTicketsFragmentViewModel by viewModel()

    private val adapter by lazy {
        ListDelegationAdapter(allTicketsAdapter())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAllTicketsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.ticketsState.observe(viewLifecycleOwner) {
            adapter.items = it
            adapter.notifyDataSetChanged()
        }
        binding.ticketsRV.adapter = adapter
    }
}