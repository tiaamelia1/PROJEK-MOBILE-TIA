
package com.example.edushare.Search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.edushare.databinding.FragmentTabLatihanBinding

class TabLatihanFragment : Fragment() {

    private var _binding: FragmentTabLatihanBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTabLatihanBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        val dataMateri = listOf(
            MateriModel(
                "Latihan Soal Struktur Data",
                "Teknik Informatika",
                "Semester 3",
                "4.7",
                "SD"
            ),
            MateriModel(
                "Latihan Soal Basis Data",
                "Teknik Informatika",
                "Semester 4",
                "4.8",
                "DB"
            ),
            MateriModel(
                "Latihan Soal Pemrograman Web",
                "Teknik Informatika",
                "Semester 3",
                "4.6",
                "WEB"
            )
        )

        val adapter = MateriAdapter(
            requireContext(),
            dataMateri
        )

        binding.listMateri.adapter = adapter

        binding.listMateri.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                requireContext(),
                dataMateri[position].judul,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
