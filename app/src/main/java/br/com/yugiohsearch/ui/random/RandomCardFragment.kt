package br.com.yugiohsearch.ui.random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import br.com.yugiohsearch.R
import br.com.yugiohsearch.databinding.FragmentRandomCardBinding


class RandomCardFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewModel = ViewModelProviders.of(this).get(RandomCardViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentRandomCardBinding>(
            inflater,
            R.layout.fragment_random_card,
            container,
            false
        )

        binding.randomCardViewModel = viewModel
        binding.lifecycleOwner = this

//        viewModel.cardMutableLiveData.observe(this, Observer {cards ->
//            iv_card.setImageURI(cards[0].image_url)
//        })

        return binding.root
    }
}