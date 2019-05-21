package br.com.yugiohsearch.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import br.com.yugiohsearch.R
import com.google.android.material.bottomsheet.BottomSheetBehavior

class CreateDeckFragment: Fragment() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_create_deck, container, false)

        val bottomSheet = view.findViewById<ConstraintLayout>(R.id.bottom_sheet)
        val tvTitle = view.findViewById<TextView>(R.id.tv_title)
        bottomSheetBehavior = BottomSheetBehavior.from<ConstraintLayout>(bottomSheet)

        tvTitle.setOnClickListener {
            slideUpDownBottomSheet()
        }

        return view
    }

    /***
     * Manually Slide up and Slide Down
     */
    private fun slideUpDownBottomSheet() {
        if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        } else {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }
}