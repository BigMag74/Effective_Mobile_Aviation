package com.example.effectivemobileaviation.presentation.search.adapters

import com.example.domain.model.ListItem
import com.example.domain.model.PopularDirectionModel
import com.example.effectivemobileaviation.R
import com.example.effectivemobileaviation.databinding.ItemPopularDestinationBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun popularDirectionAdapter(
    itemClickListener: (String) -> Unit
) =
    adapterDelegateViewBinding<PopularDirectionModel, ListItem, ItemPopularDestinationBinding>(
        { layoutInflater, root ->
            ItemPopularDestinationBinding.inflate(layoutInflater, root, false)
        })
    {
        binding.root.setOnClickListener {
            itemClickListener(item.country)
        }
        bind {
            binding.titleTV.text = item.country
            when (item.id) {
                1 -> {
                    binding.photoIV.setImageResource(R.drawable.stambul)
                }

                2 -> {
                    binding.photoIV.setImageResource(R.drawable.sochi)
                }

                3 -> {
                    binding.photoIV.setImageResource(R.drawable.phuket)
                }
            }

        }
    }