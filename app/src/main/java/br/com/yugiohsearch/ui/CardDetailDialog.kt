package br.com.yugiohsearch.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import br.com.yugiohsearch.R
import br.com.yugiohsearch.databinding.DialogCardBinding
import br.com.yugiohsearch.model.Card

class CardDetailDialog: DialogFragment(){

    private var card: Card = Card()

    companion object{
        fun getInstance(card: Card): CardDetailDialog {
            return CardDetailDialog().apply { this.card = card }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DataBindingUtil.inflate<DialogCardBinding>(
            LayoutInflater.from(context),
            R.layout.dialog_card,
            null,
            false
        )

        binding.card = card

        return AlertDialog.Builder(context).apply { setView(binding.root) }.create()
    }
}