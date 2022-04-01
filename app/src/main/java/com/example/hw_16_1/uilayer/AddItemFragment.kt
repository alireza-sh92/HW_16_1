package com.example.hw_16_1.uilayer

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import com.example.hw_16_1.databinding.DialogAddItemBinding
import java.util.*
import kotlin.properties.Delegates

class AddItemFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
    private lateinit var _calendr: Calendar
    private var _binding: DialogAddItemBinding? = null
    private val binding get() = _binding!!
    private lateinit var dateButton: Button
    private lateinit var timePicke: TimePicker
    private var year by Delegates.notNull<Int>()
    private var month by Delegates.notNull<Int>()
    private var day by Delegates.notNull<Int>()
    private lateinit var cancel: Button
    private lateinit var save: Button


    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        dateButton.text =
            "${p1}" + "-" + "${p2 + 1}".padStart(2, '0') + "-" + "${p3}".padStart(2, '0')
        Toast.makeText(context, "Date Set!", Toast.LENGTH_SHORT).show()
    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogAddItemBinding.inflate(LayoutInflater.from(context))
        setDate()
        setTime()
        buttonListener()

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            requireActivity().layoutInflater

            builder.setView(binding.root)
                .create()
        } ?: throw IllegalArgumentException("Activity cannot be null")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setDate() {
        _calendr = Calendar.getInstance()
        val year = _calendr.get(Calendar.YEAR)
        val month = _calendr.get(Calendar.MONTH)
        val day = _calendr.get(Calendar.DAY_OF_MONTH)
        dateButton = binding.datePickerActions
        dateButton.text =
            "$year" + "-" + "${month + 1}".padStart(2, '0') + "-" + "$day".padStart(2, '0')
        dateButton.setOnClickListener {
            DatePickerDialog(requireContext(), this, year, month, day).show()
        }
    }

    private fun setTime() {
        timePicke = binding.timePickerActions
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun buttonListener() {
        cancel = binding.cancelButton
        cancel.setOnClickListener {
            dialog?.dismiss()
        }
        save = binding.saveButton
        save.setOnClickListener {
            Toast.makeText(
                context,
                "${timePicke.hour}" + ":"
                        +
                        "${timePicke.minute}".padStart(2, '0'),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}