package com.example.effectivemobileaviation.presentation.search.adapters

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import com.example.domain.model.ListItem
import com.example.domain.model.Ticket
import com.example.effectivemobileaviation.R
import com.example.effectivemobileaviation.databinding.ItemDirectFlightBinding
import com.example.effectivemobileaviation.util.convertPriceToString
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

@SuppressLint("ResourceAsColor")
fun directFlightsAdapter() = adapterDelegateViewBinding<Ticket, ListItem, ItemDirectFlightBinding>(
    { layoutInflater, root -> ItemDirectFlightBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        binding.airlineTV.text = item.title
        binding.timeTV.text = item.timeRange.toString()
        binding.priceTV.text = convertPriceToString(item.price)
        when (itemId) {
            0L -> {
                binding.circleIV.imageTintList = ColorStateList.valueOf(R.color.red)
            }

            1L -> {
                binding.circleIV.imageTintList = ColorStateList.valueOf(R.color.blue)
            }

            2L -> {
                binding.circleIV.imageTintList = ColorStateList.valueOf(R.color.white)
            }
        }
    }
}