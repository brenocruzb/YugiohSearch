package br.com.yugiohsearch.ui.create

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.yugiohsearch.databinding.ContentFilterToolbarBinding

class ConstraintFilterToolbar(context: Context, attr: AttributeSet): ConstraintLayout(context, attr) {
    val binding = ContentFilterToolbarBinding.inflate(LayoutInflater.from(context), this, true)

    fun setViewModel(createDeckViewModel: CreateDeckViewModel?){
        binding.createDeckViewModel = createDeckViewModel
    }

    fun setSlideUpDownBottomSheet(bottomSheet: ConstraintLayout?){
        binding.bottomSheet = bottomSheet
    }
}