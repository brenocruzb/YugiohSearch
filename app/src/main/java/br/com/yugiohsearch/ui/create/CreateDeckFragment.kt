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
import br.com.yugiohsearch.model.CardFilter
import br.com.yugiohsearch.ui.create.filter.FilterCreateDeckActivity

class CreateDeckFragment: Fragment() {

    private val filterChanged = 123
    private var filter = CardFilter()

    private val viewModel: CreateDeckViewModel by lazy { ViewModelProviders.of(this).get(CreateDeckViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentCreateDeckBinding>(
            inflater,
            R.layout.fragment_create_deck,
            container,
            false
        ).apply {
            lifecycleOwner = this@CreateDeckFragment
            createDeckViewModel = viewModel
        }

        viewModel.event.observe(this, Observer {
            startActivityForResult(Intent(
                context,
                FilterCreateDeckActivity::class.java).apply { putExtra("event", filter) },
                filterChanged
            )
        })

        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == filterChanged && resultCode == FilterCreateDeckActivity.APPLIED_FILTER) {
            if (data?.extras?.containsKey("event") == true) {
                filter = data.extras?.get("event") as CardFilter
                viewModel.onSearch(filter)
            }
        } else if (requestCode == filterChanged && resultCode == FilterCreateDeckActivity.RESET_FILTER) {
            if (data?.extras?.containsKey("event") == true) {
                filter = CardFilter()
                viewModel.onSearch(filter)
            }
        }
    }
}