package br.com.yugiohsearch.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.yugiohsearch.R
import br.com.yugiohsearch.databinding.FragmentSearchCardBinding
import br.com.yugiohsearch.util.CustomSetter
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

        viewModel.cardMutableLiveData.observe(this, Observer {cards ->
            CustomSetter.loadImage(iv_card, cards[0].image_url ?: "")
        })

        return binding.root
    }
}