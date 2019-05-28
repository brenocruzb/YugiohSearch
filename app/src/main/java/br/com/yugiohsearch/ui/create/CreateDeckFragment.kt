package br.com.yugiohsearch.ui.create

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.yugiohsearch.R
import br.com.yugiohsearch.databinding.FragmentCreateDeckBinding
import br.com.yugiohsearch.ui.create.filter.FilterCreateDeckActivity

class CreateDeckFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewModel = ViewModelProviders.of(this).get(CreateDeckViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentCreateDeckBinding>(
            inflater,
            R.layout.fragment_create_deck,
            container,
            false
        ).apply {
            lifecycleOwner = this@CreateDeckFragment
            createDeckViewModel = viewModel
        }

        viewModel.filter.observe(this, Observer {
            startActivity(Intent(context, FilterCreateDeckActivity::class.java))
        })

        return binding.root
    }
}