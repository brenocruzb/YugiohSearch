package br.com.yugiohsearch.ui.create.filter

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.yugiohsearch.R
import br.com.yugiohsearch.databinding.ActivityFilterCreateDeckBinding

class FilterCreateDeckActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(FilterCreateDeckViewModel::class.java)
        DataBindingUtil.setContentView<ActivityFilterCreateDeckBinding>(this, R.layout.activity_filter_create_deck).apply {
            filterCreateDeckViewModel = viewModel
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        viewModel.filter.observe(this, Observer {
            Toast.makeText(applicationContext, it.fuzzyName, Toast.LENGTH_LONG).show()
        })

//        if (intent.extras?.containsKey("filter") == true) {
//            filter = intent.extras?.get("filter") as FilterBilling
//            configureSpinner()
//            loadFiltersToView()
//
//            btnApply.setOnClickListener {
//                applyFilters()
//            }
//        } else finish()
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
//        filter = FilterBilling().apply {
//            index = 0
//            length = filter.length
//        }
//
//        val intent = Intent()
//        intent.putExtra("filter", filter)
//        setResult(RESET_FILTER, intent)
        finish()
    }



}