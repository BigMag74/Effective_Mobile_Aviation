package com.example.effectivemobileaviation.presentation.airTickets

import com.example.domain.model.FlyAwayMusicallyModel
import com.example.domain.model.ListItem
import com.example.effectivemobileaviation.R
import com.example.effectivemobileaviation.databinding.ItemFlyAwayMusicallyBinding
import com.example.effectivemobileaviation.util.convertPriceToString
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun flyAwayMusicallyAdapter() =
    adapterDelegateViewBinding<FlyAwayMusicallyModel, ListItem, ItemFlyAwayMusicallyBinding>(
        { layoutInflater, root -> ItemFlyAwayMusicallyBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            binding.title.text = item.title
            binding.town.text = item.town
            binding.price.text = convertPriceToString(item.price)

            when (item.id) {
                1 -> {
                    binding.posterIV.setImageResource(R.drawable.die_antwoord)
                }

                2 -> {
                    binding.posterIV.setImageResource(R.drawable.socrat_i_lera)
                }

                3 -> {
                    binding.posterIV.setImageResource(R.drawable.lampabickt)
                }
            }
        }
    }