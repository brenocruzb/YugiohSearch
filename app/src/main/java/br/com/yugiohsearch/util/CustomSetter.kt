package br.com.yugiohsearch.util

import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView

@BindingAdapter("imageUrl")
fun SimpleDraweeView.setImageUrl(urlImage: String?) = setImageURI(urlImage)