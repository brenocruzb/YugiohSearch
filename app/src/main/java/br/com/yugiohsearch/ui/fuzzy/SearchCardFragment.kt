package br.com.yugiohsearch.ui.fuzzy

import android.graphics.Point
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import br.com.yugiohsearch.R
import br.com.yugiohsearch.databinding.FragmentSearchCardBinding
import kotlinx.android.synthetic.main.fragment_search_card.*


class SearchCardFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewModel = ViewModelProviders.of(this).get(SearchCardViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentSearchCardBinding>(
            inflater,
            R.layout.fragment_search_card,
            container,
            false
        )

        binding.searchCardViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.listCards.observe(this, Observer { listCards ->
            val searchAdapter = SearchCardAdapter(listCards){
                Toast.makeText(context, it.name, Toast.LENGTH_LONG).show()
            }
            recycler_list.layoutManager = GridLayoutManager(context, spanCount())
            recycler_list.setHasFixedSize(true)
            recycler_list.swapAdapter(searchAdapter, true)
        })

        return binding.root
    }

    private fun spanCount(): Int{
        val display = activity?.windowManager?.defaultDisplay
        val size = Point()
        display?.getSize(size)
        val width = size.x

        return width / 300
    }
}