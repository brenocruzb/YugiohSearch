package br.com.yugiohsearch.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.yugiohsearch.R
import br.com.yugiohsearch.databinding.FragmentCreateDeckBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class CreateDeckFragment: Fragment() {

//    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val lifecycle = this
        val viewModel = ViewModelProviders.of(this).get(CreateDeckViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentCreateDeckBinding>(
            inflater,
            R.layout.fragment_create_deck,
            container,
            false
        ).apply {
            lifecycleOwner = lifecycle
            createDeckViewModel = viewModel
        }


        return binding.root
//        val view = inflater.inflate(R.layout.fragment_create_deck, container, false)
//
//        val bottomSheet = view.findViewById<ConstraintLayout>(R.id.bottom_sheet)
//        val tvTitle = view.findViewById<ConstraintLayout>(R.id.filter_container)
////        val ivExpand = view.findViewById<ImageView>(R.id.iv_expand)
//        bottomSheetBehavior = BottomSheetBehavior.from<ConstraintLayout>(bottomSheet)
//        bottomSheetBehavior.isHideable = false
////
//        tvTitle.setOnClickListener {
//            slideUpDownBottomSheet()
//        }
//
//        var expandable = true
//        ivExpand.setOnClickListener {
//            val animation = AnimationUtils.loadAnimation(context, R.anim.fade_in)
//            animation.setAnimationListener(object : Animation.AnimationListener{
//                override fun onAnimationRepeat(animation: Animation?) {}
//
//                override fun onAnimationEnd(animation: Animation?) {}
//
//                override fun onAnimationStart(animation: Animation?) {
//                    if(expandable)
//                        ivExpand.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.ic_expand_less))
//                    else
//                        ivExpand.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.ic_expand_more))
//
//                    expandable = !expandable
//                }
//            })
//            ivExpand.startAnimation(animation)
//        }

//        return view
    }

//    /***
//     * Manually Slide up and Slide Down
//     */
//    private fun slideUpDownBottomSheet() {
//        if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
//            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
//        } else {
//            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
//        }
//    }
}