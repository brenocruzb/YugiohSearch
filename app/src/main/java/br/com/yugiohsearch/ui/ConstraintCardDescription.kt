package br.com.yugiohsearch.ui

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.yugiohsearch.R

class ConstraintCardDescription(context: Context, attr: AttributeSet): ConstraintLayout(context, attr) {

//    private val binding: ConstraintCardDescriptionBinding = ConstraintCardDescriptionBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.content_card_description, this, false)
        addView(view)
    }

//    fun setViewModel(customView: ConstraintCardDescription, searchCardViewModel: SearchCardViewModel){
//        Log.i("Test", searchCardViewModel.editSearch.value)
//    }
}