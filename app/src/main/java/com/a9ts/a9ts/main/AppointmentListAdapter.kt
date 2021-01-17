package com.a9ts.a9ts.main

import android.util.Log
import android.view.View
import com.a9ts.a9ts.BaseRecyclerViewAdapter
import com.a9ts.a9ts.ItemAdapter
import com.a9ts.a9ts.R
import com.a9ts.a9ts.databinding.AppointmentItemBinding
import com.a9ts.a9ts.databinding.AppointmentRejectedItemBinding
import com.a9ts.a9ts.model.Appointment
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class AppointmentsListAdapter(items: List<ItemAdapter>) : BaseRecyclerViewAdapter(items)

class AppointmentItemAdapter(private val appointment: Appointment) :
    ItemAdapter(R.layout.appointment_item) {

    override fun setupView(view: View) {
        val binding = AppointmentItemBinding.bind(view)
        binding.fullname.text = appointment.inviteeName
        binding.description.text = appointment.description
        binding.date.text =
            appointment.dateAndTime.format(DateTimeFormatter.ofPattern("E dd LLL")).toString()
        binding.time.text =
            DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(appointment.dateAndTime)
                .toString()
        binding.root.setOnClickListener {
            Log.i("AppointmentItemAdapter", "Clicked on appointment")
        }
    }
}

class AppointmentRejectedInfoItemAdapter(private val appointment: Appointment) :
    ItemAdapter(R.layout.appointment_rejected_item) {

    override fun setupView(view: View) {
        val binding = AppointmentRejectedItemBinding.bind(view)
        binding.fullname.text = appointment.inviteeName
        binding.date.text =
            appointment.dateAndTime.format(DateTimeFormatter.ofPattern("E dd LLL")).toString()
        binding.root.setOnClickListener {
            Log.i("AppointmentItemAdapter", "Clicked on appointment rejected")
        }
    }
}