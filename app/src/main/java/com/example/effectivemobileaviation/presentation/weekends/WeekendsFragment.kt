package com.example.effectivemobileaviation.presentation.weekends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.effectivemobileaviation.databinding.FragmentWeekendsBinding

class WeekendsFragment : Fragment() {

    private var _binding: FragmentWeekendsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentWeekendsBinding.inflate(inflater, container, false)
        return binding.root
    }
}