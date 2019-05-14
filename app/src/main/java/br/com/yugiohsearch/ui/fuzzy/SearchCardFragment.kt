package br.com.yugiohsearch.ui.fuzzy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import br.com.yugiohsearch.R
import br.com.yugiohsearch.databinding.FragmentSearchCardBinding
import br.com.yugiohsearch.ui.CardDetailDialog
import br.com.yugiohsearch.util.Constants
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
                CardDetailDialog.getInstance(card = it).show(fragmentManager!!, "Paggcerto")
            }
            recycler_list.layoutManager = GridLayoutManager(context, Constants.convertPixelsToDp(Constants.point(activity).x.toFloat(), context!!).toInt() / 100)
            recycler_list.setHasFixedSize(true)
            recycler_list.swapAdapter(searchAdapter, true)
        })

        return binding.root
    }
}