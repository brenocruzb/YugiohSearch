package br.com.yugiohsearch.ui.create

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.yugiohsearch.databinding.ItemFilterCardBinding
import br.com.yugiohsearch.model.FilterDescription

class FilterToolbarAdapter(private val listFilterDescription: List<FilterDescription>, private val listener:(FilterDescription) -> Unit): RecyclerView.Adapter<FilterToolbarAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemFilterCardBinding.inflate(LayoutInflater.from(parent.context)))

    override fun getItemCount(): Int = /*listFilterDescription.size*/ 5

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(listFilterDescription[0/*position*/], listener)

    inner class ViewHolder(val binding: ItemFilterCardBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(filterDescription: FilterDescription, listener: (FilterDescription) -> Unit){
            binding.cardFilter = filterDescription
            binding.ivClose.setOnClickListener { listener(filterDescription) }
        }
    }
}