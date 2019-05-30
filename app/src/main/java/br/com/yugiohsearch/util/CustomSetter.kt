package br.com.yugiohsearch.util

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.yugiohsearch.R
import br.com.yugiohsearch.model.Card
import br.com.yugiohsearch.model.CardFilter
import br.com.yugiohsearch.ui.CardDetailDialog
import br.com.yugiohsearch.ui.create.FilterToolbarAdapter
import br.com.yugiohsearch.ui.fuzzy.SearchCardAdapter
import com.bumptech.glide.Glide
import com.facebook.drawee.view.SimpleDraweeView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import net.cachapa.expandablelayout.ExpandableLayout


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

    val spanCount = Constants.convertPixelsToDp(Constants.point(activity).x.toFloat(), context).toInt() / 100
    layoutManager = GridLayoutManager(context,  spanCount)
    setHasFixedSize(true)
    swapAdapter(searchAdapter, true)
}

@BindingAdapter("cardFilter")
fun RecyclerView.setCardFilter(filter: CardFilter?){
    filter ?: return

    val filterToolbarAdapter = FilterToolbarAdapter(filter.getFilterDescription()){

    }

    layoutManager = LinearLayoutManager(context)
    setHasFixedSize(true)
    swapAdapter(filterToolbarAdapter, true)

}

@BindingAdapter("expandLayout")
fun ImageView.updateBottomSheet(expandableLayout: ExpandableLayout?){
    setOnClickListener{

        expandableLayout?.toggle()

        val animation = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        animation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {}

            override fun onAnimationStart(animation: Animation?) {
                if(expandableLayout?.isExpanded == true)
                    setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_expand_more))
                else
                    setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_expand_less))
            }
        })
        startAnimation(animation)
    }
}

@BindingAdapter(value = ["slideBottomSheet", "imageViewEvent"], requireAll = false)
fun ConstraintLayout.slideBottomSheet(bottomSheet: ConstraintLayout?, imageView: ImageView?){
    val bottomSheetBehavior = BottomSheetBehavior.from<ConstraintLayout>(bottomSheet).apply {
        isHideable = false
        setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED){
                    imageView?.visibility = View.VISIBLE
                }
                else if(newState == BottomSheetBehavior.STATE_COLLAPSED){
                    imageView?.visibility = View.GONE
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })
    }

    setOnClickListener {
        bottomSheetBehavior.state =
            if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED){
                imageView?.visibility = View.VISIBLE
                BottomSheetBehavior.STATE_EXPANDED
            }
            else {
                imageView?.visibility = View.GONE
                BottomSheetBehavior.STATE_COLLAPSED
            }
    }
}