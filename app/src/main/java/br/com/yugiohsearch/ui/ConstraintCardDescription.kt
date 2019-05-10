package br.com.yugiohsearch.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.yugiohsearch.databinding.ContentCardDescriptionBinding
import br.com.yugiohsearch.model.Card

class ConstraintCardDescription(context: Context, attr: AttributeSet): ConstraintLayout(context, attr) {

    private val binding: ContentCardDescriptionBinding = ContentCardDescriptionBinding.inflate(LayoutInflater.from(context), this, true)

    fun setCard(card: Card?){
        binding.card = card
    }
}