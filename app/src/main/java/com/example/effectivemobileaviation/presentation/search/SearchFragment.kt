package com.example.effectivemobileaviation.presentation.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.effectivemobileaviation.R
import com.example.effectivemobileaviation.databinding.FragmentSearchBinding
import com.example.effectivemobileaviation.presentation.search.adapters.directFlightsAdapter
import com.example.effectivemobileaviation.presentation.search.adapters.popularDirectionAdapter
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SearchViewModel by viewModel()

    private val args: SearchFragmentArgs by navArgs()

    private val adapter by lazy {
        ListDelegationAdapter(
            directFlightsAdapter(),
            popularDirectionAdapter { binding.editTextTo.setText(it) }
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchRV.adapter = adapter
        binding.editTextFrom.setText(args.countryFrom)

        viewModel.state.observe(viewLifecycleOwner) {
            renderState(it)
        }

        setOnClickListeners()
        initializeEditTextToListeners()
    }

    override fun onResume() {
        super.onResume()
        binding.editTextTo.requestFocus()
    }

    private fun setOnClickListeners() {
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

    private fun initializeEditTextToListeners() {
        binding.editTextTo.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE && binding.editTextTo.text.isNotEmpty()) {
                viewModel.setFilledState()
            }
            false
        }

        binding.editTextTo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.isNullOrEmpty())
                    viewModel.setEmptyState()
                else
                    viewModel.setFilledState()
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        binding.iconCross.setOnClickListener {
            binding.editTextTo.setText("")
        }
    }

    private fun renderState(state: SearchState) {
        when (state) {
            is SearchState.EmptyCountryTo -> {
                adapter.items = state.content
                adapter.notifyDataSetChanged()

                binding.iconBack.visibility = GONE
                binding.iconSwap.visibility = GONE
                // TODO chipsVisibility
                binding.allTicketsTV.visibility = GONE

                binding.iconPlane.visibility = VISIBLE
                binding.iconLoupe.visibility = VISIBLE
                binding.difficultRouteTV.visibility = VISIBLE
                binding.iconDifficultRoute.visibility = VISIBLE
                binding.AnywhereTV.visibility = VISIBLE
                binding.iconAnywhere.visibility = VISIBLE
                binding.weekendsTV.visibility = VISIBLE
                binding.iconWeekends.visibility = VISIBLE
                binding.hotTicketsTV.visibility = VISIBLE
                binding.iconHotTickets.visibility = VISIBLE
            }

            is SearchState.FilledCountryTo -> {
                adapter.items = state.content
                adapter.notifyDataSetChanged()

                binding.iconBack.visibility = VISIBLE
                binding.iconSwap.visibility = VISIBLE
                // TODO chipsVisibility
                binding.allTicketsTV.visibility = VISIBLE

                binding.iconPlane.visibility = GONE
                binding.iconLoupe.visibility = GONE
                binding.difficultRouteTV.visibility = GONE
                binding.iconDifficultRoute.visibility = GONE
                binding.AnywhereTV.visibility = GONE
                binding.iconAnywhere.visibility = GONE
                binding.weekendsTV.visibility = GONE
                binding.iconWeekends.visibility = GONE
                binding.hotTicketsTV.visibility = GONE
                binding.iconHotTickets.visibility = GONE
            }
        }
    }

    companion object {

        const val VISIBLE = View.VISIBLE
        const val GONE = View.GONE
    }
}