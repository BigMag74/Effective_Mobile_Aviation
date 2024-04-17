package com.example.effectivemobileaviation.presentation.airTickets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.domain.model.FlyAwayMusicallyModel
import com.example.effectivemobileaviation.R
import com.example.effectivemobileaviation.databinding.ItemFlyAwayMusicallyBinding
import com.example.effectivemobileaviation.util.convertPriceToString

class FlyAwayMusicallyAdapter() : Adapter<FlyAwayMusicallyViewHolder>() {

    var items = listOf<FlyAwayMusicallyModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlyAwayMusicallyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FlyAwayMusicallyViewHolder(
            ItemFlyAwayMusicallyBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: FlyAwayMusicallyViewHolder, position: Int) {
        holder.bind(items[position])
    }
}

class FlyAwayMusicallyViewHolder(
    private val binding: ItemFlyAwayMusicallyBinding,
) : ViewHolder(binding.root) {

    fun bind(item: FlyAwayMusicallyModel) {
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