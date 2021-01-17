package com.a9ts.a9ts.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.a9ts.a9ts.ItemAdapter
import com.a9ts.a9ts.model.AppointmentRepository
import com.a9ts.a9ts.databinding.MainFragmentBinding

class MainFragment : Fragment() {
    lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = AppointmentsListAdapter(makeAppointmentsList())
        return binding.root
    }

    fun makeAppointmentsList(): List<ItemAdapter> {
        val appointmentList = AppointmentRepository.appointmentList
        val rejectedAppointmentsAdapters =
            appointmentList.map { AppointmentRejectedInfoItemAdapter(it) }
        val appointmentsAdapters = appointmentList.map { AppointmentItemAdapter(it) }
        return rejectedAppointmentsAdapters + appointmentsAdapters
    }
}