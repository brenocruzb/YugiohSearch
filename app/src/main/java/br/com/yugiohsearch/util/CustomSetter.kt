package br.com.yugiohsearch.util

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.yugiohsearch.R
import br.com.yugiohsearch.model.Card
import br.com.yugiohsearch.ui.CardDetailDialog
import br.com.yugiohsearch.ui.fuzzy.SearchCardAdapter

import com.bumptech.glide.Glide
import com.facebook.drawee.view.SimpleDraweeView

@BindingAdapter("imageUrl")
fun SimpleDraweeView.setImageUrl(urlImage: String?) = setImageURI(urlImage)

@BindingAdapter("glideImage")
fun ImageView.setGlideImage(urlImage: String?){
    Glide
        .with(context)
        .load(urlImage)
        .fitCenter()
        .placeholder(R.drawable.back_card)
        .into(this)
}

@BindingAdapter("cardList")
fun RecyclerView.setCardList(listCards: List<Card>?){
    listCards ?: return
    val activity = context as AppCompatActivity

    val searchAdapter = SearchCardAdapter(listCards){
        CardDetailDialog.getInstance(card = it).show(activity.supportFragmentManager, "dialog_tag")
    }

    val spanCount = Constants.convertPixelsToDp(Constants.point(activity).x.toFloat(), context!!).toInt() / 100
    layoutManager = GridLayoutManager(context,  spanCount)
    setHasFixedSize(true)
    swapAdapter(searchAdapter, true)
}