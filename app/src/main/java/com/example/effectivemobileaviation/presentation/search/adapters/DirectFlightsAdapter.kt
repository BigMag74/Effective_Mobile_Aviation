package com.example.effectivemobileaviation.presentation.search.adapters

import android.annotation.SuppressLint
import com.example.domain.model.ListItem
import com.example.domain.model.Ticket
import com.example.effectivemobileaviation.R
import com.example.effectivemobileaviation.databinding.ItemDirectFlightBinding
import com.example.effectivemobileaviation.util.convertListToString
import com.example.effectivemobileaviation.util.convertPriceToString
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

@SuppressLint("ResourceAsColor")
fun directFlightsAdapter() = adapterDelegateViewBinding<Ticket, ListItem, ItemDirectFlightBinding>(
    { layoutInflater, root -> ItemDirectFlightBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        binding.airlineTV.text = item.title
        binding.timeTV.text = convertListToString(item.timeRange)
        binding.priceTV.text = convertPriceToString(item.price)
        when (layoutPosition) {
            0 -> {
                binding.circleIV.background.setTint(getColor(R.color.red))
            }

            1 -> {
                binding.circleIV.background.setTint(getColor(R.color.blue))
            }

            2 -> {
                binding.circleIV.background.setTint(getColor(R.color.white))
            }
        }
    }
}