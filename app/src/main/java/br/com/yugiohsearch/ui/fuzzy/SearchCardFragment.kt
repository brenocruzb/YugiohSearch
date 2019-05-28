package br.com.yugiohsearch.ui.fuzzy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import br.com.yugiohsearch.R
import br.com.yugiohsearch.databinding.FragmentSearchCardBinding


class SearchCardFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewModel = ViewModelProviders.of(this).get(SearchCardViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentSearchCardBinding>(
            inflater,
            R.layout.fragment_search_card,
            container,
            false
        ).apply {
            searchCardViewModel = viewModel
            lifecycleOwner = this@SearchCardFragment
        }

        return binding.root
    }
}