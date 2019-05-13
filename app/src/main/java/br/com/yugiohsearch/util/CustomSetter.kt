package br.com.yugiohsearch.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.yugiohsearch.model.Card
import br.com.yugiohsearch.ui.fuzzy.SearchCardAdapter
import com.facebook.drawee.view.SimpleDraweeView


@BindingAdapter("imageUrl")
fun SimpleDraweeView.setImageUrl(urlImage: String?) = setImageURI(urlImage)

@BindingAdapter("cardList")
fun RecyclerView.setCardList(listCards: List<Card>?){
    listCards ?: return

    val searchAdapter = SearchCardAdapter(listCards){

    }

    layoutManager = GridLayoutManager(context, 3)
    setHasFixedSize(true)
    swapAdapter(searchAdapter, true)
}