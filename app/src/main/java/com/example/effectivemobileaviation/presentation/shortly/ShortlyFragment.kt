package com.example.effectivemobileaviation.presentation.shortly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.effectivemobileaviation.databinding.FragmentShortlyBinding

class ShortlyFragment : Fragment() {

    private var _binding: FragmentShortlyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentShortlyBinding.inflate(inflater, container, false)
        return binding.root
    }
}