package com.example.effectivemobileaviation.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.effectivemobileaviation.databinding.FragmentAirTicketsBinding

class AirTicketsFragment : Fragment() {

    private var _binding: FragmentAirTicketsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAirTicketsBinding.inflate(inflater, container, false)
        return binding.root
    }
}