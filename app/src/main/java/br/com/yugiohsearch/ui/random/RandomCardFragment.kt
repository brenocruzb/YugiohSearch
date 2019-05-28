package br.com.yugiohsearch.ui.random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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
        ).apply {
            randomCardViewModel = viewModel
            lifecycleOwner = this@RandomCardFragment
        }

        viewModel.messageError.observe(this, Observer { message ->
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        })

        return binding.root
    }
}