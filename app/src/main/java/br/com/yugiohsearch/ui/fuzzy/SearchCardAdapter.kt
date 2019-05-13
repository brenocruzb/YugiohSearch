package br.com.yugiohsearch.ui.fuzzy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.yugiohsearch.databinding.ItemGridCardBinding
import br.com.yugiohsearch.model.Card

class SearchCardAdapter(private val listCards: List<Card>, private val listener:(card: Card) -> Unit): RecyclerView.Adapter<SearchCardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemGridCardBinding.inflate(LayoutInflater.from(parent.context)))

    override fun getItemCount(): Int = listCards.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(listCards[position], listener)

    inner class ViewHolder(private val binding: ItemGridCardBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(card: Card, listener: (card: Card) -> Unit) {
            binding.card = card
            binding.root.setOnClickListener { listener(card) }
        }
    }
}