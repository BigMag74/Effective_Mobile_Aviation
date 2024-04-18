package com.example.effectivemobileaviation.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.effectivemobileaviation.R
import com.example.effectivemobileaviation.databinding.FragmentSearchBinding

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

        binding.stambulIV.setOnClickListener {
            binding.editTextTo.setText(binding.stambulTitleTV.text)
        }
        binding.stambulTitleTV.setOnClickListener {
            binding.editTextTo.setText(binding.stambulTitleTV.text)
        }
        binding.stambulDescriptionTV.setOnClickListener {
            binding.editTextTo.setText(binding.stambulTitleTV.text)
        }
        binding.sochiIV.setOnClickListener {
            binding.editTextTo.setText(binding.sochiTitleTV.text)
        }
        binding.sochiTitleTV.setOnClickListener {
            binding.editTextTo.setText(binding.sochiTitleTV.text)
        }
        binding.sochiDescriptionTV.setOnClickListener {
            binding.editTextTo.setText(binding.sochiTitleTV.text)
        }

        binding.phuketIV.setOnClickListener {
            binding.editTextTo.setText(binding.phuketTitleTV.text)
        }
        binding.phuketTitleTV.setOnClickListener {
            binding.editTextTo.setText(binding.phuketTitleTV.text)
        }
        binding.phuketDescriptionTV.setOnClickListener {
            binding.editTextTo.setText(binding.phuketTitleTV.text)
        }
    }
}