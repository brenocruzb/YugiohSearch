package br.com.yugiohsearch.ui.create.filter

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.yugiohsearch.R
import br.com.yugiohsearch.databinding.ActivityFilterCreateDeckBinding
import br.com.yugiohsearch.model.CardFilter

class FilterCreateDeckActivity : AppCompatActivity(){

    companion object{
        val APPLIED_FILTER = 258
        val RESET_FILTER = 369
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (intent.extras?.containsKey("event") == true) {

            val viewModel = ViewModelProviders.of(this).get(FilterCreateDeckViewModel::class.java)
            val filter = intent.extras?.get("event") as CardFilter

            DataBindingUtil.setContentView<ActivityFilterCreateDeckBinding>(this, R.layout.activity_filter_create_deck).apply {
                this.filterCreateDeckViewModel = viewModel
                this.filter = filter
            }

            viewModel.filter.observe(this, Observer {
                setResult(APPLIED_FILTER, Intent().apply { putExtra("event", filter) })
                finish()
            })

        } else finish()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_filter, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.action_clear -> clearFilters()
        }
        return true
    }

    private fun clearFilters() {
        setResult(RESET_FILTER, Intent().apply { putExtra("event", CardFilter()) })
        finish()
    }



}