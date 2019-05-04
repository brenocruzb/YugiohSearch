package br.com.yugiohsearch.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import br.com.yugiohsearch.R
import com.bumptech.glide.Glide

object CustomSetter {
    @BindingAdapter("imageUrl")
    fun loadImage(imageView: ImageView, urlImage: String){
        Glide.with(imageView.context)
            .load(urlImage)/*.apply(RequestOptions().circleCrop())*/
            .placeholder(R.drawable.back_card)
            .into(imageView)
    }
}