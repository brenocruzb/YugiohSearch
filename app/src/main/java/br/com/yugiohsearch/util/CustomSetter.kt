package br.com.yugiohsearch.util

import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView

object CustomSetter {
    @BindingAdapter("imageUrl")
    fun loadImage(draweeView: SimpleDraweeView, urlImage: String){
//        Glide.with(imageView.context)
//            .load(urlImage)/*.apply(RequestOptions().circleCrop())*/
//            .placeholder(R.drawable.back_card)
//            .into(imageView)

        draweeView.setImageURI(urlImage)
    }
}