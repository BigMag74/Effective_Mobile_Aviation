package com.example.effectivemobileaviation.presentation.search

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.navigation.fragment.navArgs
import com.example.effectivemobileaviation.databinding.DialogFragmentSearchBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SearchDialogFragment : BottomSheetDialogFragment() {

    private var _binding: DialogFragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val args: SearchDialogFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DialogFragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setOnShowListener {
            val bottomSheetDialog = it as BottomSheetDialog
            val parentLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { view ->
                val behaviour = BottomSheetBehavior.from(view)
                setupFullHeight(view)
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
                behaviour.isDraggable = false
            }
        }
        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.editTextFrom.setText(args.countryFrom)
        binding.iconCross.setOnClickListener {
            binding.editTextTo.setText("")
        }
    }

    override fun onResume() {
        super.onResume()
        binding.editTextTo.requestFocus()
    }
}

private fun setupFullHeight(bottomSheet: View) {
    val layoutParams = bottomSheet.layoutParams
    layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
    bottomSheet.layoutParams = layoutParams
}